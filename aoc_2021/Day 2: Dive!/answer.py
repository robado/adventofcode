# --- Day 2: Dive! ---
## What do you get if you multiply your final horizontal position by your final depth?

# Code cleanup coming up......
def run():
    inputs = read_file()
    print('Part 1 answer: ', part1(inputs))
    print('Part 2 answer: ', part2(inputs))

def part1(inputs):
    horizontal = 0
    depth = 0
    last_position = 0
    for i in range(len(inputs)):
        if inputs[i].split(' ')[0] == 'forward':
            horizontal += int(inputs[i].split(' ')[1])
        if inputs[i].split(' ')[0] == 'down':
            depth += int(inputs[i].split(' ')[1])
        if inputs[i].split(' ')[0] == 'up':
            depth -= int(inputs[i].split(' ')[1])
        
    last_position = (horizontal * depth)
    return last_position

def part2(inputs):
    aim = 0
    horizontal = 0
    depth = 0
    for i in range(len(inputs)):
        if inputs[i].split(' ')[0] == 'forward':
            horizontal += int(inputs[i].split(' ')[1])
            depth += (int(inputs[i].split(' ')[1]) * aim)
        if inputs[i].split(' ')[0] == 'down':
            aim += int(inputs[i].split(' ')[1])
        if inputs[i].split(' ')[0] == 'up':
            aim -= int(inputs[i].split(' ')[1])
    return(multiply(horizontal, depth))

def multiply(x, y):
    return x*y


def read_file():
    file = open("inputs.txt", "r")
    #file = open("test.txt", "r")
    inputs = file.read().splitlines()
    #inputs = file.read()
    return inputs

if __name__ == '__main__':
    print('--- Day 2: Dive! ---')
    run()
    
