package com.example.loginpage;

 class UserProfile {

    public String user_age;
    public String user_gender;
    public String user_bodywt;
    public String user_wakeup;
    public String user_sleep;
public UserProfile()
{

}
    UserProfile(String user_age,String user_gender,String user_bodywt,String user_wakeup,String user_sleep)
    {
       this.user_age= user_age;
       this.user_gender= user_gender;
       this.user_bodywt= user_bodywt;
       this.user_wakeup=user_wakeup;
       this.user_sleep=user_sleep;

    }



   public String getUser_age() {
       return user_age;
    }

    public void setUser_age(String user_age) {
       this.user_age = user_age;
    }

    public String getUser_gender() {
       return user_gender;
    }

    public void setUser_gender(String user_gender) {
       this.user_gender = user_gender;
    }

    public String getUser_bodywt() {
       return user_bodywt;
    }

    public void setUser_bodywt(String user_bodywt) {
       this.user_bodywt = user_bodywt;
    }

    public String getUser_wakeup() {
       return user_wakeup;
    }

    public void setUser_wakeup(String user_wakeup) {
       this.user_wakeup = user_wakeup;
    }

    public String getUser_sleep() {
       return user_sleep;
    }

    public void setUser_sleep(String user_sleep) {
       this.user_sleep = user_sleep;
    }


 }
