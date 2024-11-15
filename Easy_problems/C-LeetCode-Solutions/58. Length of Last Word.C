int lengthOfLastWord(char* s) {
    int length = 0;
    int i = strlen(s) - 1; // Get the index of the last character

    while (i >= 0 && s[i] == ' ') {
        i--;
    }

    while (i >= 0 && s[i] != ' ') {
        length++;
        i--;
    }
    return length;
}

