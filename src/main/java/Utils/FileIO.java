/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;
import Model.Data;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author gzzengzihang
 */
public class FileIO {
    
    public static List<Data> readData(String path, int row, int column){
        BufferedReader br = null;
        List<Data> dataList = new ArrayList<>();
        try{
            br = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
            String line;
            while((line = br.readLine()) != null){
                String[] temp = line.split(" ");
                if (temp.length != (row * column + 1))
                    throw new Exception("arguments wrong!!");
                double[][] dataMatrix = new double[row][column];
                int target = -1;
                for (int i = 0; i < temp.length; i++){
                    if (i == (temp.length - 1))
                        target = Integer.valueOf(temp[i]);
                    else{
                        int rowIndex = i / column;
                        int columnIndex = i % column;
                        dataMatrix[rowIndex][columnIndex] = Double.valueOf(temp[i]);
                    }
                }
                Data data = new Data(dataMatrix, target);
                dataList.add(data);
            }
        br.close();
        }catch (Exception e){
            System.out.println(e.toString());
        }
        return dataList;
    }
    
//    public static void main(String[] args){
//        List<Data> dataList = readData("src/Resources/data.txt", 3, 1);
//        System.out.println(dataList);
//    }
}
