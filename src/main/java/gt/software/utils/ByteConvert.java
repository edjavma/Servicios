package gt.software.utils;

public class ByteConvert {
	   
    public static String byteToASCII (byte[] data) {
      StringBuilder localStringBuffer = new StringBuilder();
      for (int i = 0; i < data.length; i++) {
          localStringBuffer.append((char)(data[i] & 0xFF));
      }
      return localStringBuffer.toString();
  }
  
  public static String byteToASCII (byte[] data, int init, int end) {
      StringBuilder localStringBuffer = new StringBuilder(); 
      for (int i = init; i <= end; i++) {
          localStringBuffer.append((char)(data[i] & 0xFF));
      }
      return localStringBuffer.toString();
  }
  
  public static int byteToInteger(byte[] data) {        
      return Integer.valueOf(byteToHex(data).replace(" ",""),(byte)0x10).intValue();
  }
  
  public static String byteToHex(byte[] data)  {
      StringBuilder localStringBuilder = new StringBuilder();
      for (int i = 0; i < data.length; i++)  {
          String str;
          if ((str=Integer.toHexString(data[i]&0xFF).toUpperCase()).length()==1) {
              localStringBuilder.append(0);
          }
      localStringBuilder.append(str).append(" ");
      }
      return localStringBuilder.substring(0, localStringBuilder.length() - 1);
  }
  
  public static String byteToHex(byte[] data, int init, int end) {
      StringBuilder localStringBuilder = new StringBuilder();
      for (int i = init; i <= end; i++)  {
          String str;
          if ((str=Integer.toHexString(data[i]&0xFF).toUpperCase()).length()==1) {
              localStringBuilder.append(0);
          }
      localStringBuilder.append(str).append(" ");
      }
      return localStringBuilder.substring(0, localStringBuilder.length() - 1);
  }
  
  public static byte[] hexStringToByteArray(String s) {
      int len = s.length();
      byte[] data = new byte[len / 2];
      for (int i = 0; i < len; i += 2) {
          data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                           + Character.digit(s.charAt(i+1), 16));
      }
      return data;
  }
}
