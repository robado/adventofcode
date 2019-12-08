with open("puzzle_input") as file:
    mass = 0
    for line in file:
        mass += int(line) // 3 - 2
print(mass)
