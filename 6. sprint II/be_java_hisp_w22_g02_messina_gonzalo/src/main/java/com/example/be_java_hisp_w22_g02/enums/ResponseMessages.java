package com.example.be_java_hisp_w22_g02.enums;

public enum ResponseMessages {
    USER_ID_NOT_FOUND {
        @Override
        public String toString() {
            return "User with id: %d not found.";
        }
    },
    SAME_USER_ID{
        @Override
        public String toString() {
            return "User ids can't be the same.";
        }
    },
    FOLLOW_TWICE{
        @Override
        public String toString() {
            return "You can't follow the same user twice.";
        }
    },
    NOT_FOLLOWING_USER {
      @Override
      public String toString() {return "You are not following user with id: %d.";}
    },
    SUCCESSFUL_FOLLOW{
        @Override
        public String toString() {
            return "User followed successfully.";
        }
    },
    SUCCESSFUL_UNFOLLOW{
        @Override
        public String toString() {
            return "User unfollowed successfully.";
        }
    },
    NAME_ASC{
        @Override
        public String toString() {
            return "name_asc";
        }
    },
    NAME_DESC{
        @Override
        public String toString() {
            return "name_desc";
        }
    },
    WRONG_SORTING_ORDER{
        @Override
        public String toString() {
            return "The sorting order %s doesn't exist.";
        }
    },
    DATE_ASC{
        @Override
        public String toString() {
            return "date_asc";
        }
    },
    DATE_DESC{
        @Override
        public String toString() {
            return "date_desc";
        }
    }


}
