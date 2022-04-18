# --- Day 3: Binary Diagnostic ---
# What is the power consumption of the submarine? (Be sure to represent your answer in decimal, not binary.)

def run():
    # part1(read_file())
    part2()
    testing(read_file())

def testing(binaries):
    gamma, epsilon = '', ''
    binary_list = []
    print(binary_list)
    # make list size of binary
    for i in range(len(binaries[0])):
        print(i)
        binary_list.append([]) # [[], [], [], [], []]
    print(binary_list)
    
    # make binaries to a list
    # split single bytes colums to their own list
    # add everything to the list
    for byte in binaries:
        print(byte)
        split = list(byte) # didn't know you can do this
        print(split)
        for i in range(len(split)):
            binary_list[i].append(split[i])

    print('binary_list: ', binary_list)
    for byte_lists in binary_list:
        # calculate gamma
        gamma += get_gamma(byte_lists)
        # calculate epsilon
        epsilon += get_epsilon(byte_lists)


    print('gamma in the end:', gamma)
    print('epsilon in the end:', epsilon)

    # Convert to decimal
    gamma_decimal = int(gamma, 2)
    epsilon_decimal = int(epsilon, 2)

    # Calculate power consumption
    power_consumption = gamma_decimal*epsilon_decimal

    print('gamma decimal:', gamma_decimal)
    print('epsilon_decimal:', epsilon_decimal)
    print('power_consumption:', power_consumption)
    

def get_gamma(byte_lists):
    print('byte_lists', byte_lists)
    zero_count, one_count = 0, 0
    
    for byte in byte_lists:
        if byte == '0':
            print('nolla:', byte)
            zero_count += 1
        elif byte == '1':
            print('one:', byte)
            one_count += 1

    print('zero_count:', zero_count)
    print('one_count:', one_count)

    if zero_count > one_count:
        print('zero count bigger than one_count')
        return '0'
    elif zero_count < one_count:
        print('one count bigger than zero_count')
        return '1'

def get_epsilon(byte_lists):
    print('get epsilon')
    print('byte_lists', byte_lists)
    zero_count, one_count = 0, 0
    
    for byte in byte_lists:
        if byte == '0':
            print('nolla:', byte)
            zero_count += 1
        elif byte == '1':
            print('one:', byte)
            one_count += 1

    print('zero_count:', zero_count)
    print('one_count:', one_count)

    if zero_count < one_count:
        print('zero count bigger than one_count')
        return '0'
    elif zero_count > one_count:
        print('one count bigger than zero_count')
        return '1'


def part1(binaries):
    power_comsumption = 0
    gamma_rate = []
    epsilon_rate = []
    zeros = 0 
    ones = 0
    zero_count = 0
    one_count = 0
    for i in range(len(binaries)):
        print('string ', binaries[i], ' length', len(binaries[i]))
        print('first: ', binaries[i][0])
        
        print('for loop for binarie len starting')
        for ii in range(len(binaries[i])):
            print('ii ', ii)
            if int(binaries[i][ii]) == 0:
                print('zero')
                zero_count += 1
            if int(binaries[i][ii]) == 1:
                print('one')
                one_count += 1
        print('for loop for binarie len ending')

        if zero_count > one_count:
            print('zero count bigger than one_count')
            gamma_rate.append(0)
            print('gamma_rate ', gamma_rate)
        if zero_count < one_count:
            print('one count bigger than zero_count')
            gamma_rate.append(1)
            print('gamma_rate ', gamma_rate)

        """
        for ii in range(len(binaries[i])):
            print(binaries[i][ii])
            if int(binaries[i][ii]) == 0:
                print('nolla')
                zero_count += 1
            if int(binaries[i][ii]) == 1:
                print('one')
                one_count += 1
        """

    print('zero_count', zero_count)
    print('one_count', one_count)
    print('gamma_rate: ', gamma_rate)
    print('eplison_rate: ', epsilon_rate)
                

    print(binaries)

def part2():
    pass

def read_file():
    file = open("input.txt", "r")
    #file = open("test.txt", "r")
    inputs = file.read().splitlines()
    #inputs = file.read()
    return inputs

if __name__ == "__main__":
    run()