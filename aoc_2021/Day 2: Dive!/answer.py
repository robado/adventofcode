# --- Day 2: Dive! ---
## What do you get if you multiply your final horizontal position by your final depth?

def run():
    print('run')
    inputs = read_file()
    print('Part 1 answer: ', part1(inputs))
    print('Part 2 answer: ', part2(inputs))

def part1(inputs):
    horizontal = 0
    depth = 0
    last_position = 0
    print('part1')
    print(type(inputs))
    for i in range(len(inputs)):
        print(inputs[i].split(','))
        print(inputs[i].split(' '))
        print(type(inputs[i].split(' ')))
        print(inputs[i].split(' ')[0])
        if inputs[i].split(' ')[0] == 'forward':
            print('this is forward')
            print(inputs[i].split(' ')[1])
            horizontal += int(inputs[i].split(' ')[1])
            print(horizontal)
        if inputs[i].split(' ')[0] == 'down':
            print('this is down')
            depth += int(inputs[i].split(' ')[1])
        if inputs[i].split(' ')[0] == 'up':
            print('this is up')
            depth -= int(inputs[i].split(' ')[1])
        
    print('horizontal: ', horizontal)
    print('depth: ', depth)
    last_position = (horizontal * depth)
    # print('last position: ', last_position)
    return last_position

def part2(inputs):
    aim = 0
    horizontal = 0
    depth = 0
    final_position = 0
    print('part2')
    for i in range(len(inputs)):
        #print(inputs[i].split(','))
        #print(inputs[i].split(' '))
        #print(inputs[i].split(' ')[0])
        if inputs[i].split(' ')[0] == 'forward':
            print('dir: ' + inputs[i].split(' ')[0] + ' - amount: ' + inputs[i].split(' ')[1])
            horizontal += int(inputs[i].split(' ')[1])
            depth += (int(inputs[i].split(' ')[1]) * aim)
            print('horizontal: ', horizontal)
            print('depth:', depth)
        if inputs[i].split(' ')[0] == 'down':
            print('dir: ' + inputs[i].split(' ')[0] + ' - amount: ' + inputs[i].split(' ')[1])
            aim += int(inputs[i].split(' ')[1])
            print('aim:', aim)
        if inputs[i].split(' ')[0] == 'up':
            print('dir: ' + inputs[i].split(' ')[0] + ' - amount: ' + inputs[i].split(' ')[1])
            aim -= int(inputs[i].split(' ')[1])
            print('aim: ', aim)
    
    print('')
    print('horizontal: ', horizontal)
    print('depth: ', depth)

    # final_position += (horizontal*aim)
    # print('final position: ', horizontal*aim)
    # print('Final position: ', multiply(horizontal, depth))
    return(multiply(horizontal, depth))

def multiply(x, y):
    print('multiply')
    print('x ', x)
    print('y ', y)
    print('x*y ', x*y)
    return x*y


def read_file():
    file = open("inputs.txt", "r")
    #file = open("test.txt", "r")
    inputs = file.read().splitlines()
    #inputs = file.read()
    print(inputs)
    return inputs

if __name__ == '__main__':
    print('main')
    run()
    
