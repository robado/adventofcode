# Part 1
print("Part 1:")
with open("puzzle_input") as file:
    mass = 0
    for line in file:
        mass += int(line) // 3 - 2
print(mass)  # 3415695

# Part 2
print("Part 2:")
with open("puzzle_input") as p_file:
    total_f = 0
    tmp_value = 0
    for line in p_file:
        tmp_value = int(line)
        while tmp_value > 0:
            print(tmp_value)
            tmp_value = int(tmp_value) // 3 - 2
            if tmp_value > 0:
                total_f += tmp_value
    print(total_f)  # 5120654

# Puzzle that didn't work on my first try
# with open("test") as puzzle_file:
#     total_fuel = 0
#     fuel_double_check = 0
#     for line in puzzle_file:
#         fuel_double_check += int(line) // 3 - 2
#         if fuel_double_check > 2:
#             total_fuel += fuel_double_check
#         while fuel_double_check > 2:
#             fuel_double_check = int(fuel_double_check) // 3 - 2
#             if fuel_double_check < 2:
#                 fuel_double_check = 0
#                 break
#             else:
#                 total_fuel += fuel_double_check
#     print(total_fuel)
