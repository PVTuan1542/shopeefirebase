package com.shopee.me;


    public class User {
        private String Name;
        private String Password;
        private String Phone;

        public User() {
        }

        public User(String name250, String password250) {
            Name = name250;
            Password = password250;

        }

        public String getPhone() {
            return Phone;
        }

        public void setPhone(String phone250) {
            Phone = phone250;
        }

        public String getName() {
            return Name;
        }

        public void setName(String name250) {
            Name = name250;
        }

        public String getPassword() {
            return Password ;
        }

        public void setPassword(String password250) {
            Password  = password250;
        }
    }

