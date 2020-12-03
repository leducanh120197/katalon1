
list1 = ["l11", "l12"]
list2 = ["l21", "l22", "li23", "li24"]
list3 = ["l31", "l32"]
list4 = ['']
list_list = [list1, list2, list3, list4]

# print(list_list[2][0])


def next_line_for_convert_two_to_one(maxs, at):  # List<Integer> next(List<Integer> maxs, List<Integer> at)
    maxs_lenght = len(maxs) - 1
    # i = len(maxs) -1
    for i in range(maxs_lenght, -1, -1):
        if at[i] < (maxs[i] - 1):
            t = at[i]
            t += 1
            at[i] = t
            break
        else:
            at[i] = 0
    return at


def convert_two_dimensional_to_one_dimensional(list_list_input):
    tests_data_dto = []      # List<QA24TestDataDto>
    sizes_per_sheet = []    # List<Integer>
    for sheet in list_list_input:
        sizes_per_sheet.append(len(sheet))

    total = 1
    # size_of_sheet = []      # List<Integer>
    for i in range(0, len(sizes_per_sheet)):
        # size_of_sheet.append(sizes_per_sheet[i])
        total *= sizes_per_sheet[i]

    at = []                 # List<Integer>
    for integers in list_list_input:
        at.append(0)

    for i in range(0, total):
        test_data_dto = []
        x = len(list_list_input)
        for index in range(0, len(list_list_input)):
            # qa24TestDataDto.setWithIndex(index + 1, matrixInput.get(index).get(at.get(index)));
            dto = list_list_input[index][at[index]]
            test_data_dto.append(dto)
        print("test_data_dto: " + str(test_data_dto))
        tests_data_dto.append(test_data_dto)
        at = next_line_for_convert_two_to_one(sizes_per_sheet, at)
    return tests_data_dto


if __name__ == "__main__":
    convert_two_dimensional_to_one_dimensional(list_list)
