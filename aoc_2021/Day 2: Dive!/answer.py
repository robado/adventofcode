# --- Day 2: Dive! ---
## What do you get if you multiply your final horizontal position by your final depth?
def run():
    print('run')
    inputs = read_file()
    print('Last position: ', part1(inputs))
    part2()

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



def part2():
    horizontal = 0
    depth = 0
    last_position = 0
    aim = 0
    print('part2')

def read_file():
    file = open("inputs.txt", "r")
    # file = open("test.txt", "r")
    inputs = file.read().splitlines()
    #inputs = file.read()
    print(inputs)
    return inputs

if __name__ == '__main__':
    print('main')
    run()
    
