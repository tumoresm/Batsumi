package com.example.batsumi.Login_AND_SignUp

import android.net.Uri

class UserInfo {
    var email: String? = null
    var pass: String? = null
    var con_pass: String? = null
    var mob: String? = null
    var img: Uri? = null

    constructor() {}

    //    public UserInfo(String email, String pass, String mob) {
    //        this.email = email;
    //        this.pass = pass;
    //        this.mob = mob;
    //    }
    constructor(email: String?, pass: String?, mob: String?, img: Uri?) {
        this.email = email
        this.img = img
        this.pass = pass
        this.mob = mob
    }

    @JvmName("getImg1")
    fun getImg(): Uri? {
        return img
    }

    @JvmName("setImg1")
    fun setImg(img: Uri?) {
        this.img = img
    }

    fun getMob() {
        this.mob = mob
    }

    fun getEmail() { this.email

    }
}