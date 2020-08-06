package studentmanager.domain;

import javax.persistence.*;



    @Entity
    @Table(name = "student")
    public class Student {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer studentId;
        @Column (name = "first_name")
        private String firstName;
        @Column (name = "last_name")
        private String lastName;
        @Column (name = "phone_number")
        private String phoneNumber;
        private String email;

        @ManyToOne
        @JoinColumn (name = "groupId")
        private Group group;

        public Student() {
        }



        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public Group getGroup() {
            return group;
        }

        public void setGroup(Group group) {
            this.group = group;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "studentId=" + studentId +
                    ", firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", phoneNumber='" + phoneNumber + '\'' +
                    ", email='" + email + '\'' +
                    ", group=" + group +
                    '}';
        }
    }


