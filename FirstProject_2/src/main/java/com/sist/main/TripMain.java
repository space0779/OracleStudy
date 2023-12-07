package com.sist.main;

import java.util.*;
import com.sist.dao.*;
import java.io.*;
public class TripMain {
	private static ArrayList<TripVO> flist=new ArrayList<TripVO>();
	private static ArrayList<String> mlist=new ArrayList<String>();
	static TripDAO dao=new TripDAO();
	static
	{
		FileReader fr=null;
		BufferedReader br=null;
		ObjectInputStream ois=null;
		FileInputStream fis=null;
		StringBuffer sb=new StringBuffer();
		StringBuffer sb2=new StringBuffer();
		StringBuffer sb3=new StringBuffer();
		try {

			
			fr=new FileReader("c:\\java_data\\trip.txt");
			String data="";
			int i=0;
			while((i=fr.read())!=-1)
			{
				data+=(char)i;
				
			}
			sb.append(data);
			fr.close();
			
			
//			fr=new FileReader("c:\\java_data\\TripImage.txt");
//			String data2="";
//			int j=0;
//			while((j=fr.read())!=-1)
//			{
//				data2+=(char)j;
//				
//			}
//			sb2.append(data2);
//			fr.close();
			
			fr=new FileReader("c:\\java_data\\imagedetail.txt");
			String data3="";
			int k=0;
			while((k=fr.read())!=-1)
			{
				data3+=(char)k;
				
			}
			sb3.append(data3);
			fr.close();
			
//			fis.close();
//			br.close();
			
			String Trip_data=sb.toString();
			String[] fd=Trip_data.split("\n");
			
//			String Trip_data2=sb2.toString();
//			String[] fd2=Trip_data2.split("\n");
			
			String Trip_data3=sb3.toString();
			String[] fd3=Trip_data3.split("\n");
			
			for(String s:fd)
			{
				//StringTokenizer st=new StringTokenizer(s,"|");
				TripVO vo=new TripVO();
				String[] detail=s.split("\\|");
				
				vo.setFno(Integer.parseInt(detail[0]));
				vo.setTitle(detail[1]);
				vo.setPoster(detail[2]);
				vo.setCont(detail[3]);
				vo.setNavi(detail[4]);
				vo.setAddr(detail[5]);
				vo.setPhone(detail[6]);
				vo.setRestday(detail[7]);
				vo.setBhour(detail[8]);
				vo.setTag(detail[9]);
				flist.add(vo);
				
				
				//s=s.substring(0,s.indexOf("?"));
				//vo.setTag(st.nextToken());
				//vo.setFno(Integer.parseInt(st.nextToken()));
				//vo.setTitle(st.nextToken());
				//System.out.println(detail.length);
			}
//			for(String s:fd2)
//			{
//				Ilist.add(s);
//				//System.out.println(s);
//			}
			for(String s:fd3)
			{
				mlist.add(s);
			}
			
//			int index = 0;
//			for (String s : Ilist) {
//			    String p = s.substring(0, s.indexOf("\r"));
//			    flist.get(index).setPoster(p);
//			    index++;
//			}

			for(int a=0;a<flist.size();a++)
			{
				String d=mlist.get(a);
				//d=d.substring(0,d.indexOf("\r"));
				flist.get(a).setDeimage(d);
			}
			dao.musicInsert(flist);
			
		}catch(Exception e)
        {
			e.printStackTrace();
        }finally {
        	try {
        		fr.close();
        	}catch(Exception e)
        	{
        		
        	}
        }
		
	}
	
	
	public static void main(String[] args) {
		TripMain fm=new TripMain();
		//System.out.println("저장완료");
		for(TripVO vo:flist) 
		{
			System.out.println("태그:"+vo.getTag());
			System.out.println("번호:"+vo.getFno());
			System.out.println("업체명:"+vo.getTitle());
			System.out.println("이미지:"+vo.getPoster());
			System.out.println("설명:"+vo.getCont());
			System.out.println("주소:"+vo.getAddr());
			System.out.println("전화:"+vo.getPhone());
			System.out.println("상세이미지:"+vo.getDeimage());
			System.out.println("===========================");
		}
		System.out.println(flist.size());
		System.out.println(mlist.size());
	}
}
	

