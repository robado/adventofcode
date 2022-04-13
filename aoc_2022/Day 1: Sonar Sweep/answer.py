# How many measurements are larger than the previous measurement?

measurements = 0 
num2 = 0
with open('inputs.txt') as file:
    for lines in file:
        line = lines.rstrip()

        num1 = int(line[::1])

        if num1 > num2:
            if num2 == 0:
                num2 = num1    
            else:
                num2 = num1
                measurements += 1
        else:
            num2 = num1

print('========== Finally printing the amount of measurements ==========')
print(measurements)