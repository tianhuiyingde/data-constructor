package com.axxqa.dataconstructor.resp;

import lombok.Data;

/**
 * @author tianhuiying on 2021/6/1.
 * @version 1.0
 */
@Data
public class LoginResp {

        /**
         * sessionId : UnZvZEm1T2GOUDx7pHSpkesP0YDcpkJSpSSSjNEu46sLypI8FlXopqmTV306+Cu0Fxr+0H8HcX7SmukwCGATBPDCGYwx/lO1TAkdmiY+JYRTAELhLIaRQsz1HhhwOJ+y1GZp2QfgzKmOLEDhG2SPh87jce14PCV/JmbDA75Cm9wYL/EA7hjI2wA0IqgekzufsUNLkH1VK2mpI4LuusIc0+QPLCvGerdw3jRnxE17Mr7hK4quN23YSsVQwj9o7d8A7vgZbIeMOzd1ENbCNCSODNZzos+o4OaX6cbQAiBI4biFz/Dz2rJ0IIPKvw6gZ4QsFXCMUZC06P6Uu4iujY0Lkw==
         * username : tianhuiying@aixuexi.com
         * token : Bearer eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyTmFtZSI6IueUsOaDoOmiliIsInVzZXJJZCI6ODF9.ipuR8Duv0nbcHPCRrwB8T6eNuklhyctoswmfTW6TkXQ
         * userVo : {"id":81,"oaLoginId":"tianhuiying","oaUserId":3175,"oaEmail":"tianhuiying@aixuexi.com","oaPassword":"3045066037419c43f9fe63397e97a57f","oaUserName":"田惠颖","oaWorkCode":"GS010607","oaStatus":1,"ppUserId":0,"ppUserName":"","ppTelephone":"13691286968","ppGsId":119508209238188137,"ppInstitutionId":0,"ppInstitutionName":"","ppPortraitPath":"","userType":1}
         */

        private String sessionId;
        private String username;
        private String token;
        private UserVoBean userVo;

        @Data
        public static class UserVoBean {
            /**
             * id : 81
             * oaLoginId : tianhuiying
             * oaUserId : 3175
             * oaEmail : tianhuiying@aixuexi.com
             * oaPassword : 3045066037419c43f9fe63397e97a57f
             * oaUserName : 田惠颖
             * oaWorkCode : GS010607
             * oaStatus : 1
             * ppUserId : 0
             * ppUserName :
             * ppTelephone : 13691286968
             * ppGsId : 119508209238188137
             * ppInstitutionId : 0
             * ppInstitutionName :
             * ppPortraitPath :
             * userType : 1
             */

            private int id;
            private String oaLoginId;
            private int oaUserId;
            private String oaEmail;
            private String oaPassword;
            private String oaUserName;
            private String oaWorkCode;
            private int oaStatus;
            private int ppUserId;
            private String ppUserName;
            private String ppTelephone;
            private long ppGsId;
            private int ppInstitutionId;
            private String ppInstitutionName;
            private String ppPortraitPath;
            private int userType;

        }
}
