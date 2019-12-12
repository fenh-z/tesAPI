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

        String keyTmp = "7c01b847370ccc1d9740f676";
        String key = CodecPersonalityUtil.decodeRC2(keyTmp);

        String encryptName = "01PIPCPEDKKOHCMEGECKOJCNFENOEBLNKK";
        String encryptID = "01AKOKGFJEKADPPCBHFHPKLKFLJOJHDDIKENAPMJCKCDOGLNDK";
        String encryptAdd = "01NAFJJOJLJCGMOFDOCLAKFDKFOLOBCCDPJFHOBAOKNGBFHOOBBBHBCIBIMIEKNADDBIFKNFJLCMIIOODKFEBELPHLHOOMGKIMNAHKPCKOLMBBFBEK";

        String decryptName = CodecPersonalityUtil.decodeDES(encryptName.substring(2), key);
        String decryptID = CodecPersonalityUtil.decodeDES(encryptID.substring(2), key);
        String decryptAdd = CodecPersonalityUtil.decodeDES(encryptAdd.substring(2), key);

        System.out.println("name = " + decryptName + "; ID = " + decryptID + "; Add = " + decryptAdd);


        System.out.println("");

        String userName = "ftp5511";
        String userPwd = "q2#E5Ty&";

        String encryptUserName = CodecPersonalityUtil.encodeRC2(userName);
        String encryptUserPwd= CodecPersonalityUtil.encodeRC2(userPwd);

        System.out.println("encryptUserName = " + encryptUserName + "; encryptUserPwd = " + encryptUserPwd );

    }

}

