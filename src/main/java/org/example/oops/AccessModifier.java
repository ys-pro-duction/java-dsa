package org.example.oops;


class AccessModifier {

    public static void main(String[] args) {

        MyClass myClass = new MyClass();
        /**Public
         Visibility: Everywhere. A public member can be accessed from any other class in any package.*/
        int publicVariable = myClass.publicVariable;

        /**Protected
         Visibility: Within the same package and subclasses. A protected member can be accessed by
         classes in the same package and by subclasses (even if they are in different packages).*/
        int protectedVariable = myClass.protectedVariable;

        /**Default (Package-Private)
         Visibility: Within the same package. A member with no access modifier (also called package-private)
         can only be accessed by classes within the same package.*/
        int defaultVariable = myClass.defaultVariable;

        /**Private
         Visibility: Within the same class. A private member can only be accessed
         within the class it is defined.*/
        int privateVariable = myClass.privateVariable;

        /**
         * Summary Table
         * Modifier  	Class	Package	Subclass	World
         * public   	Yes 	Yes 	Yes     	Yes
         * protected	Yes 	Yes 	Yes     	No
         * (default)	Yes 	Yes 	No      	No
         * private  	Yes 	No  	No      	No*/
    }

    public static class MyClass {
        public int publicVariable;
        protected int protectedVariable;
        int defaultVariable;
        private int privateVariable;

        public void publicMethod() {
        }

        protected void protectedMethod() {
        }

        void defaultMethod() {
        }

        private void privateMethod() {
        }
    }
}
