
# Part 2
# print("Part 2:")
# with open("test") as puzzle_file:
#     total_fuel = 0
#     fuel_double_check = 0
#     final_fuel = 0
#     for line in puzzle_file:
#         total_fuel += int(line) // 3 - 2
#         # print(total_fuel)
#         fuel_double_check = total_fuel
#         while fuel_double_check > 2:
#             # print("inside while")
#             # print(total_fuel)
#             fuel_double_check = int(fuel_double_check) // 3 - 2
#             # print("before if: " + str(fuel_double_check))
#             if fuel_double_check < 2:
#                 # print("inside if: " + str(fuel_double_check))
#                 break
#             total_fuel = total_fuel + fuel_double_check
#             # print(total_fuel)
#             # if fuel_double_check < 2:
#             #     pass
#             # else:
#             #     print("inside else")
#             #     print(total_fuel)
#             #     fuel_double_check = int(fuel_double_check) // 3 - 2
#             #     total_fuel = total_fuel + fuel_double_check
#             #     print(total_fuel)
#     final_fuel += total_fuel
#     print(final_fuel)