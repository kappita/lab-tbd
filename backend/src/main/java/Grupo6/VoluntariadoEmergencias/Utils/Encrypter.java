package Grupo6.VoluntariadoEmergencias.Utils;

public class Encrypter {

    private Encrypter() {}

    public static String encrypt(String password, String username){

        if(password.length() == 0){
            return "";
        }

        int max = 20;
        int i = 0;
        String outString = "";
        int l = 33 + password.length();
        outString += (char) l;

            for(; i < password.length(); i++){

                int j = i % username.length();

                int asciiPass = (int) password.charAt(i);
                int asciiUser = (int) username.charAt(j);

                int sum = asciiPass + asciiUser;
                int rem = (sum % 94) + 33;

                outString += (char) rem;
            }

            for(; i < max; i++){

                int j = i % username.length();

                int asciiUser = (int) username.charAt(j);

                int sum = asciiUser + i;
                int rem = (sum % 94) + 33;

                outString += (char) rem;
            }

        return outString;
    }

    public static String decrypt(String encryptedPassword, String username){

        if(encryptedPassword.length() == 0){
            return "";
        }

        String outString = "";
        int m = encryptedPassword.charAt(0);
        int l = m - 33;
        System.out.println(l);

        for(int i = 1; i < l+1; i++){

            int j = (i-1) % username.length();

            int asciiEncrypted = (int) encryptedPassword.charAt(i);

            int asciiUser = (int) username.charAt(j);

            int sum = asciiEncrypted - 33 - asciiUser;

            while(sum < 33){
                sum += 94;
            }

            outString += (char) sum;
        }

        return outString;
    }
}
