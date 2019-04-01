from collections import Counter


def main():
    pass

class Tree:
    def __init__(self, united):
        self.united = united


if __name__ == "__main__":
    s = input()
    c = Counter([s_ for s_ in s])
    sums = c["0"] + c["1"]
    print(sums - (max(c["0"], c["1"]) - min(c["0"], c["1"])))
