npublic class Problem4Main {
    interface Animal {
        void eat();
    }

    interface Pet extends Animal {
        void play();
    }

    static class Dog implements Pet {
        public void eat() { System.out.println("Dog is eating."); }
        public void play() { System.out.println("Dog is playing."); }
    }

    public static void main(String[] args) {
        Dog d = new Dog();
        d.eat();
        d.play();
    }
}
