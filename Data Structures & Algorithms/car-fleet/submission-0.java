class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        Car[] cars = new Car[n];

        for (int i = 0; i < n; i++) {
            cars[i] = new Car(position[i], speed[i]);
        }

        Arrays.sort(cars, Comparator.comparingInt(Car::getPosition).reversed());

        Stack<Double> stack = new Stack<>();

        for (Car car : cars) {
            double timeToTarget = ((double) target - car.getPosition()) / car.getSpeed();
            stack.push(timeToTarget);

            if (stack.size() > 1 && stack.peek() <= stack.get(stack.size() - 2)) {
                stack.pop();
            }
        }

        return stack.size();
    }

    class Car {
        int position;
        int speed;

        Car(int position, int speed) {
            this.position = position;
            this.speed = speed;
        }

        public int getPosition() {
            return position;
        }

        public int getSpeed() {
            return speed;
        }
    }
}
