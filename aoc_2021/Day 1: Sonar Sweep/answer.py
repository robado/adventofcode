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

print('Sonar Sweep measurements amount was: ', measurements)

# --- Part Two ---
# was too lazy to do code cleanup... I will do it later
n = 0
count = 0
num1 = 0
num2 = 0
window_size = 3
window_sum = 0

file = open("inputs.txt", "r")
inputs = file.read().splitlines()
inputs = [ int(x) for x in inputs ]
print(inputs)

def sliding_window(inputs, window_size):
    num1 = 0
    num2 = 0
    window_sum = 0
    summa = 0
    if len(inputs) <= window_size: # this might even bee useless i think
        print('len(inputs) <= window_size:')
        return inputs
    for i in range(len(inputs) - window_size + 1):
        #if previous_window_sum > window_sum:
            #print(inputs[i:i+window_size])
        print(inputs[i:i+window_size])
        window_sum = sum(inputs[i:i+window_size])
        num1 = sum(inputs[i:i+window_size])
        print('sum of 3 value', window_sum)
        if num1 > num2:
            if num2 == 0:
                num2 = num1    
            else:
                print('num1 > num2')
                print('num1', num1)
                print('num2', num2)
                num2 = num1
                summa += 1
        else:
            print('else')
            print('num1', num1)
            print('num2', num2)
            num2 = num1
        print('summa', summa)

sliding_window(inputs, 3)