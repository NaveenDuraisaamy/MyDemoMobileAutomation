package com.velocitor.mobile.utils;
import java.io.*;import java.util.*;
public final class Config {
 private static final Properties P=new Properties();
 static { try(InputStream in=Config.class.getClassLoader().getResourceAsStream("config.properties")){ if(in!=null) P.load(in); } catch(IOException e){throw new ExceptionInInitializerError(e);} }
 private Config(){}
 public static String get(String key){ String env=System.getenv(key.toUpperCase().replace('.','_')); if(env!=null&&!env.isBlank()) return env; return P.getProperty(key); }
 public static String appiumServer(){
	 return System.getProperty("appiumServer",get("appiumServer"));}
}
