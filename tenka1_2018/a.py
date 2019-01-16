def main(string):
    if len(string) == 2:
        return string
    elif len(string) == 3:
        return string[::-1]

if __name__ == '__main__':
    s = input()
    print(main(s))

