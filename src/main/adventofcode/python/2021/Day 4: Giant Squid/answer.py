# --- Day 4: Giant Squid ---
def run():
    print('--- Day 4: Giant Squid ---')
    bingo_file = read_file()
    get_bingo_numbers(bingo_file)
    get_bingo_tables(bingo_file)
    part1(bingo_file)

def part1(bingo):
    pass

def part2():
    pass

def get_bingo_numbers(bingo):
    print('get_bingo_numbers')
    bingo_nums = bingo.readline().rstrip().split(',')
    print(bingo_nums)
    # return bingo_nums
    
def get_bingo_tables(bingo):
    print('get_bingo_tables..')
    bingo_tables = bingo.readlines()[:]
    print(bingo_tables)

    
def read_file():
    #file = open("input.txt", "r")
    file = open("test.txt", "r")
    #inputs = file.read().splitlines()
    #inputs = file.read()
    #return inputs
    return file
    
if __name__ == "__main__":
    run()