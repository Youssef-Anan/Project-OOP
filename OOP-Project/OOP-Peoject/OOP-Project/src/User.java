
public class User {
        private int ID;
        private String FirstName;
        private String LastName;
        private String Username;
        private String Password;
        public User(){
            super();
        }


        public  User(String FirstName,String LastName,String Username, String Password){

            this.FirstName=FirstName;
            this.LastName=LastName;
            this.Username=Username;
            this.Password=Password;
        }
    public  User(int ID,String FirstName,String LastName,String Username, String Password){

        this.FirstName=FirstName;
        this.LastName=LastName;
        this.Username=Username;
        this.Password=Password;
        this.ID=ID;
    }



    public int getID() {
            return ID;
        }

        public void setID(int ID) {
            this.ID = ID;
        }

        public String getFirstName() {
            return FirstName;
        }

        public void setFirstName(String firstName) {
            FirstName = firstName;
        }

        public String getLastName() {
            return LastName;
        }

        public void setLastName(String lastName) {
            LastName = lastName;
        }

        public String getUsername() {
            return Username;
        }

        public void setUsername(String username) {
            Username = username;
        }

        public String getPassword() {
            return Password;
        }

        public void setPassword(String password) {
            Password = password;
        }
    }

