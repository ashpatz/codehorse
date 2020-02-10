
package ash.patz.learning.patterns.builder;

public class Computer {

    public static class Builder {

        private String ram;
        private String cpu;
        private String storage;
        private String screenSize;
        private String processor;

        public Builder setCpu(String cpu) {
            this.cpu = cpu;
            return this;
        }

        public Builder setProcessor(String processor) {
            this.processor = processor;
            return this;
        }

        public Builder setRam(String ram) {
            this.ram = ram;
            return this;
        }

        public Builder setScreenSize(String screenSize) {
            this.screenSize = screenSize;
            return this;
        }

        public Builder setStorage(String storage) {
            this.storage = storage;
            return this;
        }

        public Computer build() {
            return new Computer(ram, cpu, storage, screenSize, processor);
        }
    }

    private String ram;
    private String cpu;
    private String storage;
    private String screenSize;
    private String processor;

    private Computer(String ram, String cpu, String storage, String screenSize, String processor) {
        this.ram = ram;
        this.cpu = cpu;
        this.storage = storage;
        this.screenSize = screenSize;
        this.processor = processor;
    }
}
