import json
import xlrd


class ExcelUtils:

    @staticmethod
    def get_column_index_dict(first_row_in_excel, excel_field_dto_list):
        # get column index mapping
        # print("get_column_index_dict: working...")
        column_index_dict = {}
        for index, header_name in enumerate(first_row_in_excel):
            for column in excel_field_dto_list:
                if header_name.value == column.header_name:
                    column_index_dict[index] = column.field_name
        # print(column_index_dict)
        # print("get_column_index_dict: finished...")
        return column_index_dict

    @staticmethod
    def get_json_array_from_excel(sheet, num_row, column_index_dict):
        # print("get_json_array_from_excel: working...")
        json_array = []
        for index_row in range(1, num_row):
            json_object = {}
            for column_index in column_index_dict:
                # json_object[str(column_index_dict[column_index])] = str(sheet.cell_value(index_row, column_index))
                json_object[column_index_dict[column_index]] = sheet.cell_value(index_row, column_index)
            json_array.append(json_object)
        json_array = json.dumps(json_array)
        # print(json_array)
        # print("get_json_array_from_excel: finished...")
        return json_array

    @staticmethod
    def get_data_from_excel(file_path_excel, sheet_name, excel_field_dto_list, test_dto_class):
        print("get_data_from_excel: " + sheet_name + " working...")
        wb = xlrd.open_workbook(file_path_excel)
        sheet = wb.sheet_by_name(sheet_name)
        first_row_in_excel = sheet.row(0)
        num_row = sheet.nrows

        column_index_dict = ExcelUtils.get_column_index_dict(first_row_in_excel, excel_field_dto_list)
        json_array = ExcelUtils.get_json_array_from_excel(sheet, num_row, column_index_dict)

        dto_list = json.loads(json_array, object_hook=test_dto_class.custom_dto_decoder)
        # print(dto_list)
        # print(dto_list[0].id)
        print("get_data_from_excel: from sheet " + sheet_name + " finished...")
        return dto_list

    @staticmethod
    def next_line_for_convert_two_to_one(maxs, at):
        maxs_lenght = len(maxs) - 1
        for i in range(maxs_lenght, -1, -1):
            if at[i] < (maxs[i] - 1):
                t = at[i]
                t += 1
                at[i] = t
                break
            else:
                at[i] = 0
        return at

    @staticmethod
    def convert_two_dimensional_to_one_dimensional(list_list_input):
        tests_data_dto = []  # List<QA24TestDataDto>
        sizes_per_sheet = []  # List<Integer>
        for sheet in list_list_input:
            sizes_per_sheet.append(len(sheet))

        total = 1
        for i in range(0, len(sizes_per_sheet)):
            total *= sizes_per_sheet[i]

        at = []  # List<Integer>
        for integers in list_list_input:
            at.append(0)

        for i in range(0, total):
            test_data_dto = []
            x = len(list_list_input)
            for index in range(0, len(list_list_input)):
                # qa24TestDataDto.setWithIndex(index + 1, matrixInput.get(index).get(at.get(index)));
                dto = list_list_input[index][at[index]]
                test_data_dto.append(dto)
            # print("test_data_dto: " + str(test_data_dto))
            tests_data_dto.append(test_data_dto)
            at = ExcelUtils.next_line_for_convert_two_to_one(sizes_per_sheet, at)
        return tests_data_dto
