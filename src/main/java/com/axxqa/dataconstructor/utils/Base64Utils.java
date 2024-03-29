package com.axxqa.dataconstructor.utils;

import com.alibaba.fastjson.JSONObject;
import it.sauronsoftware.base64.Base64;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Base64Utils {

	private static final int CACHE_SIZE = 1024;

	public Base64Utils() {
	}

	public static byte[] decode(String base64) throws Exception {
		return Base64.decode(base64.getBytes());
	}

	public static String encode(byte[] bytes) throws Exception {
		return new String(Base64.encode(bytes));
	}

	public static String encodeFile(String filePath) throws Exception {
		byte[] bytes = fileToByte(filePath);
		return encode(bytes);
	}

	public static void decodeToFile(String filePath, String base64) throws Exception {
		byte[] bytes = decode(base64);
		byteArrayToFile(bytes, filePath);
	}

	public static byte[] fileToByte(String filePath) throws Exception {
		byte[] data = new byte[0];
		File file = new File(filePath);
		if (file.exists()) {
			FileInputStream in = new FileInputStream(file);
			ByteArrayOutputStream out = new ByteArrayOutputStream(2048);
			byte[] cache = new byte[1024];
			boolean var6 = false;

			int nRead;
			while((nRead = in.read(cache)) != -1) {
				out.write(cache, 0, nRead);
				out.flush();
			}

			out.close();
			in.close();
			data = out.toByteArray();
		}

		return data;
	}

	public static void byteArrayToFile(byte[] bytes, String filePath) throws Exception {
		InputStream in = new ByteArrayInputStream(bytes);
		File destFile = new File(filePath);
		if (!destFile.getParentFile().exists()) {
			destFile.getParentFile().mkdirs();
		}

		destFile.createNewFile();
		OutputStream out = new FileOutputStream(destFile);
		byte[] cache = new byte[1024];
		boolean var6 = false;

		int nRead;
		while((nRead = in.read(cache)) != -1) {
			out.write(cache, 0, nRead);
			out.flush();
		}

		out.close();
		in.close();
	}


	 public static String MapToString (Map<String, Object> paramMap) throws IOException{

	        JSONObject json=new JSONObject(paramMap);
	        String s=json.toString();
	        return s;

	    }
	    // BASE64编码
	    public static String Base64Encode(String s) throws IOException {
	        BASE64Encoder encoder = new BASE64Encoder();

	        s = encoder.encode(s.getBytes("UTF-8")).replaceAll("\r\n","").replaceAll("\n","");
	        Map<String, Object> param =  new HashMap<String, Object>();
	        param.put("params",s);
	        String jsonParam= MapToString(param);
	        return jsonParam;
	    }
	 // BASE64解码
	    public static String Base64Decode(String s) throws IOException {
	        BASE64Decoder decoder = new BASE64Decoder();
	        byte[] bytes = decoder.decodeBuffer(s);
	        //System.out.println(new String(bytes, "UTF-8"));
	        return new String(bytes, "UTF-8");
	    }

}
