# --- Day 3: Binary Diagnostic ---
# What is the power consumption of the submarine? (Be sure to represent your answer in decimal, not binary.)

def run():
    # part1(read_file())
    # testing(read_file())
    testing2(read_file())
    inputs = read_file()
    print('Power consupmtion:', part1(inputs))
    # print('Life support rating:', part2(inputs))


def testing2(inputs):
    # Finding Oxygen Generator Rating
    firstData = inputs
    # print('firstData', firstData)

    # Iterate through shortened data
    i = 0
    while len(firstData) > 1:
        zeros = 0
        ones = 0

        # Binary counter
        for bitString in firstData:
            print('bitString', bitString)
            print('bitString[i]', bitString[i], [i])
            if bitString[i] == '0':
                zeros += 1
            else:
                ones += 1

        print('zeros', zeros)
        print('ones', ones)
        print('bitString[i]', bitString[i])
        # List shortener
        if zeros > ones:
            firstData = [
                bitString for bitString in firstData if bitString[i] == '0']
            print('zeros > ones:', firstData)
        else:
            firstData = [
                bitString for bitString in firstData if bitString[i] == '1']
            print('zeros < ones:', firstData)

        i += 1

    oxygenRating = ''.join(firstData)
    print('oxygenRating', oxygenRating)

    # Finding the CO2 Scrubber Rating
    secondData = inputs

    # Iterate through shortened data
    i = 0
    while len(secondData) > 1:
        zeros = 0
        ones = 0

        # Binary counter
        for bitString in secondData:
            if bitString[i] == '0':
                zeros += 1
            else:
                ones += 1

        # List shortener
        if zeros > ones:
            secondData = [
                bitString for bitString in secondData if bitString[i] == '1']
        else:
            secondData = [
                bitString for bitString in secondData if bitString[i] == '0']

        i += 1

    carbonRating = ''.join(secondData)

    print(binary_to_int(oxygenRating) * binary_to_int(carbonRating))

# Transform binary string into integer
def binary_to_int(binaryStr):
    return int(binaryStr, 2)


def part1(binaries):
    gamma, epsilon = '', ''
    index_list = get_index_list(binaries)

    for byte_lists in index_list:
        # calculate gamma
        gamma += get_gamma(byte_lists)
        # calculate epsilon
        epsilon += get_epsilon(byte_lists)

    # Convert to decimal
    gamma_decimal = int(gamma, 2)
    epsilon_decimal = int(epsilon, 2)

    # Calculate power consumption
    power_consumption = gamma_decimal*epsilon_decimal

    return power_consumption


def part2(inputs):
    print('part2')
    # life support rating=(the oxygen generator rating)*(CO2 scrubber rating)
    oxygen_generator_rating, co2_scrubber_rating = '', ''
    index_list = get_index_list(inputs)

    # Get oxygen generator rating & co2 scrubber rating
    oxygen_generator_rating = get_oxygen_rating(inputs, index_list, 0)
    co2_scrubber_rating = get_c02_rating(inputs, index_list, 0)

    # Convert to decimal
    oxygen_generator_rating = int(oxygen_generator_rating, 2)
    # co2_scrubber_rating = int(co2_scrubber_rating, 2)

    # Calculate life rating
    # life_support_rating = oxygen_generator_rating*co2_scrubber_rating

    print('life_support_rating')
    # return life_support_rating


def testing(binaries):
    gamma, epsilon = '', ''
    binary_list = []
    print(binary_list)
    # make list size of binary
    for i in range(len(binaries[0])):
        print(i)
        binary_list.append([])  # [[], [], [], [], []]
    print(binary_list)

    # make binaries to a list
    # split single bytes colums to their own list
    # add everything to the list
    for byte in binaries:
        print(byte)
        split = list(byte)  # didn't know you can do this
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


def get_index_list(binaries):
    binary_list = []
    # make list size of binary
    for i in range(len(binaries[0])):
        binary_list.append([])  # [[], [], [], [], []]

    # make binaries to a list
    # split single bytes colums to their own list
    # add everything to the list
    for byte in binaries:
        split = list(byte)  # didn't know you can do this
        for i in range(len(split)):
            binary_list[i].append(split[i])

    return binary_list


def get_gamma(byte_lists):
    zero_count, one_count = 0, 0

    for byte in byte_lists:
        if byte == '0':
            zero_count += 1
        elif byte == '1':
            one_count += 1

    if zero_count > one_count:
        return '0'
    elif zero_count < one_count:
        return '1'


def get_epsilon(byte_lists):
    zero_count, one_count = 0, 0

    for byte in byte_lists:
        if byte == '0':
            zero_count += 1
        elif byte == '1':
            one_count += 1

    if zero_count < one_count:
        return '0'
    elif zero_count > one_count:
        return '1'


def get_oxygen_generator_rating():
    print('get_oxygen_generator_rating')


def get_co2_scrubber_rating():
    print('get_co2_scrubber_rating')


def get_oxygen_rating(diagn):
    print('get_oxygen_rating')


def get_c02_rating():
    print('get_c02_rating')


def read_file():
    file = open("input.txt", "r")
    # file = open("test.txt", "r")
    inputs = file.read().splitlines()
    #inputs = file.read()
    return inputs


if __name__ == "__main__":
    """
    I didn't understand what was asked on part2 so I got some help.
    But I will try to understand and make my own solution
    """
    print('--- Day 3: Binary Diagnostic ---')
    run()
