package apipack.simpeltest;

import com.sitech.jcfx.util.CodecPersonalityUtil;

/**
 * apipack
 *
 * @Author zhangdongxiao
 * @Date 2018/4/23 上午9:29.
 */
public class Encrypt {

    public static void main(String[] args) throws Exception {

        String keyTmp = "7c01b847370ccc1d9740f676";
        String key = CodecPersonalityUtil.decodeRC2(keyTmp);

        String encryptName = "01CHJIEKHCICONMKLL";
        String encryptID = "01KJCHFGDMAKIJCBBCCIDEHNPLDGMLOLNLDGGHCKKCMEPPOCAO";
        String encryptAdd = "01NAFJJOJLJCGMOFDOCLAKFDKFOLOBCCDPJFHOBAOKNGBFHOOBBBHBCIBIMIEKNADDBIFKNFJLCMIIOODKFEBELPHLHOOMGKIMNAHKPCKOLMBBFBEK";

        String decryptName = CodecPersonalityUtil.decodeDES(encryptName.substring(2), key);
        String decryptID = CodecPersonalityUtil.decodeDES(encryptID.substring(2), key);
        String decryptAdd = CodecPersonalityUtil.decodeDES(encryptAdd.substring(2), key);

        System.out.println("name = " + decryptName + "; ID = " + decryptID + "; Add = " + decryptAdd);

    }

}

