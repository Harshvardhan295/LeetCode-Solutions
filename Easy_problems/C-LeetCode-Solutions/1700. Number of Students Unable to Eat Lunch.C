int countStudents(int* students, int studentsSize, int* sandwiches, int sandwichesSize) {
    int zeroes = 0, ones = 0;
    for (int i = 0; i < studentsSize; i++) {
        if (students[i] == 0) {
            zeroes++;
        } else {
            ones++;
        }
    }
    for (int i = 0; i < sandwichesSize; i++) {
        if (sandwiches[i] == 0) {
            if (zeroes > 0) {
                zeroes--;
            } else {
                break;
            }
        } else {
            if (ones > 0) {
                ones--;
            } else {
                break;
            }
        }
    }
    return zeroes + ones;
}
