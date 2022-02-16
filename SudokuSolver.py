import numpy as np

field1 = [[0, 3, 0, 2, 8, 7, 0, 5, 0],
          [5, 8, 0, 6, 4, 1, 0, 0, 0],
          [1, 0, 6, 9, 0, 0, 0, 2, 4],
          [2, 0, 0, 0, 6, 0, 3, 0, 8],
          [0, 9, 5, 0, 0, 0, 2, 6, 0],
          [8, 0, 4, 0, 3, 0, 0, 0, 9],
          [6, 2, 0, 0, 0, 5, 4, 0, 3],
          [0, 0, 3, 8, 2, 6, 0, 1, 5],
          [0, 5, 0, 3, 1, 4, 0, 9, 0], ]

field2 = [[0, 6, 8, 0, 0, 2, 4, 7, 9],
          [4, 0, 3, 0, 0, 8, 0, 0, 0],
          [0, 2, 1, 6, 0, 0, 5, 3, 0],
          [8, 0, 0, 0, 4, 7, 9, 1, 3],
          [7, 0, 0, 0, 0, 3, 0, 0, 4],
          [2, 3, 4, 1, 9, 0, 0, 8, 7],
          [0, 4, 7, 5, 2, 0, 0, 0, 1],
          [0, 8, 0, 4, 0, 0, 0, 2, 0],
          [0, 0, 0, 0, 0, 0, 0, 0, 0], ]

field3 = [[0, 0, 0, 8, 0, 0, 0, 0, 3],
          [0, 2, 0, 0, 1, 4, 0, 0, 0],
          [0, 0, 0, 3, 7, 0, 0, 0, 2],
          [0, 0, 2, 0, 0, 0, 0, 8, 6],
          [0, 0, 7, 0, 0, 0, 9, 0, 0],
          [1, 5, 0, 0, 0, 0, 2, 0, 0],
          [2, 0, 0, 0, 9, 3, 0, 0, 0],
          [0, 0, 0, 2, 8, 0, 0, 0, 0],
          [5, 0, 0, 0, 0, 7, 0, 0, 0], ]


def cont_row_col(grid, x, y, val):
    loc_tmp = 0
    while loc_tmp < len(grid[x]):
        if grid[x][loc_tmp] == val:
            return True
        loc_tmp = loc_tmp + 1
    loc_tmp = 0
    while loc_tmp < len(grid[x]):
        if grid[loc_tmp][y] == val:
            return True
        loc_tmp = loc_tmp + 1
    return False


def cont_sqr(grid, x, y, val):
    x_0 = (x // 3) * 3
    y_0 = (y // 3) * 3
    for i in range(0, 3):
        for j in range(0, 3):
            if grid[x_0 + i][y_0 + j] == val:
                return True
    return False


def possible(grid, x, y, val):
    return not cont_row_col(grid, x, y, val) and not cont_sqr(grid, x, y, val)


def solved(grid):
    for i in range(0, 9):
        for j in range(0, 9):
            if grid[i][j] == 0:
                return False
    return True


def solve(grid):
    for i in range(0, 9):
        for j in range(0, 9):
            if grid[i][j] == 0:
                for val in range(1, 10):
                    if possible(grid, i, j, val):
                        grid[i][j] = val
                        solve(grid)
                        grid[i][j] = 0
                return


print("\n To solve: \n")
print(np.matrix(field1))

solve(field1)

print("\n Solution:\n")
print(np.matrix(field1))

print("\n\n\n To solve: \n")
print(np.matrix(field2))

solve(field2)

print("\n Solution:\n")
print(np.matrix(field2))

print("\n\n\n To solve: \n")
print(np.matrix(field3))

solve(field3)

print("\n Solution:\n")
print(np.matrix(field3))

