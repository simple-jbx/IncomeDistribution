package utils;

import java.io.File;
import java.io.FileInputStream;  
import java.io.IOException;  
import java.io.InputStream;  
import java.util.ArrayList;  
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;  
import org.apache.poi.hssf.usermodel.HSSFSheet;  
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelUtils {

    public static <T> List<T> analysisExcel(String path, Class<T> c) {
    	File file = new File(path);
        List<T> list = new ArrayList<T>();
        InputStream inputStream = null;
        String fileName = null;
        Workbook wb = null;
        
        /**
         * 将文件按版本读进来
         */
        try{
        	inputStream = new FileInputStream(file);
            fileName = file.getName();
            //System.out.println(fileName);
            if(fileName.endsWith(".xls") || fileName.endsWith(".xlsx")){
                //2003-2007版本
                if(fileName.endsWith(".xls")){
                    POIFSFileSystem fs = new POIFSFileSystem(inputStream);
                    wb = new HSSFWorkbook(fs);
                    
                }else if( fileName.endsWith(".xlsx")){
                	//2007以上版本
                    wb = new XSSFWorkbook(inputStream);
                }else{
                	inputStream.close();
                    return null;
                }
            }
            inputStream.close();
        }catch(IOException e){
            e.printStackTrace();
        }
                
        //上传表格中Sheet的数量
        int numberOfSheets = wb.getNumberOfSheets();
        for (int numSheet = 0; numSheet < numberOfSheets; numSheet++) {  
            if(fileName.endsWith(".xls") || fileName.endsWith(".xlsx")){
            	if(fileName.endsWith(".xls")){
            		 HSSFSheet hssfSheet = (HSSFSheet) wb.getSheetAt(numSheet);  
            		 //System.out.println(fileName);
                     if (hssfSheet == null) {  
                         continue;  
                     }
                     
                     //表头（第一行）的列名称，注意这里约定任何表格第一行不放数据
                     HSSFRow hssfTitleRow = hssfSheet.getRow(0);
                     int colNum = hssfTitleRow.getPhysicalNumberOfCells();//获得列数
                     //第一行各列名称
                     String[] titles = new String[colNum];
                     for(int i = 0 ; i < colNum ; i++){
                    	 hssfTitleRow.getCell(i).setCellType(Cell.CELL_TYPE_STRING);
                         titles[i] = hssfTitleRow.getCell(i).getStringCellValue();
                     }
                     
                     //当前Sheet的行数
                     int rowNum = hssfSheet.getPhysicalNumberOfRows();
                     //System.out.println(rowNum);
                     Field fields[] = c.getDeclaredFields();
                     Map<String,Field> fieldMap = new HashMap<String, Field>();
                     for (int i = 0; i < fields.length; i++) {
                         fieldMap.put(fields[i].getName(), fields[i]);
                         //System.out.println(fields[i].getName());
                     }
                     String methodName[] = new String[fields.length];
                     Class<?> cc[] = new Class<?>[fields.length-1];
                     //这里为了使用方便cc[0]未使用
                     for(int j = 1; j < fields.length-1; j++) {
                    	 //各个属性的set方法
                         methodName[j] = "set" + fields[j].getName();
                         cc[j] = fieldMap.get(fields[j].getName()).getType();
                         //System.out.println(cc[j]);
                     }
                     try {
                    	 T t = null;
                    	 //约定第一行不算作数据
                         for (int i = 1; i < rowNum; i++) {
                        	 HSSFRow hssfRow = hssfSheet.getRow(i);	
                        	 //创建新的bean实例
                        	 t =c.newInstance();
                        	 //这里约定如果第一列数据为空则本行数据无效
                        	 if(StringUtils.isEmpty(String.valueOf(hssfSheet.getRow(i).getCell(0)))) {
                        		 continue;
                        	 }
                        	 //System.out.println(hssfRow.getRowStyle().toString());
                        	 for (int j = 1; j < fields.length-1; j++) {
                        		 Method method = c.getMethod(methodName[j], cc[j]);
                        		 //将所有列数据当做字符串处理，注意为了使用方便这里j从1开始，对应文件的第0列
                        		 HSSFCell hssfCell = hssfRow.getCell(j-1);
                        		 if(hssfCell == null)
                        			continue;
                        		 hssfCell.setCellType(Cell.CELL_TYPE_STRING);
                        		 String value = hssfCell.getStringCellValue();
                        		 //如果值为空，则不转换数据，使用默认构造器
                        		 if(StringUtils.isEmpty(value)) {
                        			 continue;
                        		 }
                        		 method.invoke(t, parseValue(value, cc[j]));
                        	 }
                        	 list.add(t);
                         }
                     } catch (Exception e) {
                    	 e.printStackTrace();
                     } 
                }
            }else {
            		//TODO above 2007
            		XSSFSheet xssffSheet =   (XSSFSheet) wb.getSheetAt(numSheet);
            		XSSFRow xssfTitleRow = xssffSheet.getRow(1);
            		int colNum = xssfTitleRow.getPhysicalNumberOfCells();//������
            		//��������һһ��������
            		String[] titles = new String[colNum];
            		for(int i = 0 ; i < colNum ; i++){
            			xssfTitleRow.getCell(i).setCellType(Cell.CELL_TYPE_STRING);
            			titles[i] = xssfTitleRow.getCell(i).getStringCellValue();
            			//System.out.println(titles[i]);
            		}
            		int rowNum = xssffSheet.getLastRowNum();//������
            		for (int rownum = 1; rownum <= rowNum; rownum++) {  
            			//��ȡָ�����������Լ��������е��ֶ� ���� private int bean.GQRY.ID
            			Field fields[] = c.getDeclaredFields();
            			Map<String,Field> fieldMap = new HashMap<String, Field>();
            			for (int i = 0; i < fields.length; i++) {
            				fieldMap.put(fields[i].getName(), fields[i]);
                        }
                        //ʹ�÷�����ƣ���ֵ�����Ӧ������
            			try {
                           for (int i = 1; i <= rowNum; i++) {
                               T t =c.newInstance();
                               for (int j = 1; j < fields.length-1; j++) {
                                 //if(fieldMap.containsKey(titles[j])){ 
                                 String fieldName = fields[j].getName();
                                 //System.out.println(fieldName);
                                 String methodName = "set" + fieldName.substring(0,1).toUpperCase()+fieldName.substring(1);
                                 //���ø��ֶζ�Ӧ��set����
                                 //System.out.println(methodName);
                                 Class<?> cc = fieldMap.get(fields[j].getName()).getType();                                  
                                 Method method = c.getMethod(methodName, cc);
                                 
                                 //��Ϊexcel���û������idҲû���Ƿ�ɾ����� ���Ӧ���ӵ�0�п�ʼ��ȡ
                                 String value = String.valueOf(xssffSheet.getRow(i).getCell(j-1));
                                 //System.out.println(value);
                                 method.invoke(t, parseValue(value, cc));
                               }
                               list.add(t);
                           }
                        } catch (Exception e) {
                             e.printStackTrace();
                        }
            		}
            }
        }
        return list;    
    }

    
    /**
     * 将String值转换为bean对象中相应属性的类型
     * @param s----获取到的值
     * @param c----要转换的类型
     * @return
     */
    private static Object parseValue(String s, Class<?> c){
        Object obj = null;
        String className = c.getName();
        //excel数值后可能默认含有小数点，去掉
        if(s.endsWith(".0")) s = s.substring(0, s.length()-2);

        //其实当所有的输入列都当做String处理后其他类型也就可以不考虑了，这里将代码留下
        if(className.equals("java.lang.String")){ //String
            obj = s;
        }else if(className.equals("java.lang.Integer")){ //Integer
        	if(!s.equals("") && s != null)
        		obj =  new Integer(s);
        	else
        		obj = new Integer("0");
        }else if(className.equals("int")){ //int
        	if(!s.equals("") && s != null)
        		obj = (int)Integer.parseInt(s);
        	else
        		obj = (int)Integer.parseInt("0");
        }else if(className.equals("java.lang.Double")){ //Double
        	if(!s.equals("") && s != null)
        		obj = new Double(s);
        	else
        		obj = new Double(s);
        }else if(className.equals("double")){ //double
        	if(!s.equals("") && s != null)
        		obj = (double)new Double(s);
        	else
        		obj = (double)new Double(s);
        }else if(className.equals("java.lang.Float")){ //Float
        	if(!s.equals("") && s != null)
        		obj = new Float(s);
        	else
        		obj = new Float("0.00");
        }else if(className.equals("float")){ //float
        	if(!s.equals("") && s != null)
        		obj = (float)new Float(s);
        	else 
        		obj = (float)new Float("0.00");
        }else if(className.equals("java.util.Date")){ //Date
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            try {
                obj = sdf.parse(s);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }else if(className.equals("long")){ //long
        	if(!s.equals("") && s != null)
        		obj = Long.parseLong(s);
        	else 
        		obj = Long.parseLong("0");
        }else if(className.equals("java.util.Long")){ //Long
        	if(!s.equals("") && s != null)
        		obj = new Long(s);
        	else
        		obj = new Long("0");
        }else if(className.equals("java.math.BigDecimal")){	
        	try{
        		obj = new BigDecimal(s);        		
        	}catch(NumberFormatException e) {
        		s = "0.00";
        		obj = new BigDecimal(s);
        	}	
        }
        return obj;
    }
}
