package apipack.simpletest;

import com.sitech.jcfx.util.CodecPersonalityUtil;

/**
 * apipack
 *
 * @Author zhangdongxiao
 * @Date 2018/4/23 上午9:29.
 */
public class Encrypt {

    public static void main(String[] args) throws Exception {

//        String keyTmp = "7c01b847370ccc1d9740f676";
//        String key = CodecPersonalityUtil.decodeRC2(keyTmp);
//
//        String encryptName = "01PIPCPEDKKOHCMEGECKOJCNFENOEBLNKK";
//        String encryptID = "01AKOKGFJEKADPPCBHFHPKLKFLJOJHDDIKENAPMJCKCDOGLNDK";
//        String encryptAdd = "01NAFJJOJLJCGMOFDOCLAKFDKFOLOBCCDPJFHOBAOKNGBFHOOBBBHBCIBIMIEKNADDBIFKNFJLCMIIOODKFEBELPHLHOOMGKIMNAHKPCKOLMBBFBEK";
//
//        String decryptName = CodecPersonalityUtil.decodeDES(encryptName.substring(2), key);
//        String decryptID = CodecPersonalityUtil.decodeDES(encryptID.substring(2), key);
//        String decryptAdd = CodecPersonalityUtil.decodeDES(encryptAdd.substring(2), key);
//
//        System.out.println("name = " + decryptName + "; ID = " + decryptID + "; Add = " + decryptAdd);
//
//
//        System.out.println("");

        String userName = "ngcsop";
        String userPwd = "a23VsuQ7";

        String encryptUserName = CodecPersonalityUtil.encodeRC2(userName);
        String encryptUserPwd = CodecPersonalityUtil.encodeRC2(userPwd);

        System.out.println("encryptUserName = " + encryptUserName + "; encryptUserPwd = " + encryptUserPwd);

        System.out.println("");
        /*
        HOSTUSER=b18bb12323
        HOSTPASSWD=d8c1dc98c633d3be
         */

        String decryptUserName = CodecPersonalityUtil.decodeRC2("6ae8fbab83f1bb70");
        String decryptUserPwd = CodecPersonalityUtil.decodeRC2("43fa2188aceb41bc31");

        System.out.println("encryptUserName = " + decryptUserName + "; encryptUserPwd = " + decryptUserPwd);

    }

}

