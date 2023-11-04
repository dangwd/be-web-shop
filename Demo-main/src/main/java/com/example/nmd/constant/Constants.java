package com.example.nmd.constant;

/**
 * CREATE BY MinhDV
 */
public interface Constants {
    interface ErrorMessageCategoryValidation {
        String LIMIT_SIZE = "Số lượng danh sản phẩm  trong một trang là từ 5 đến 50 sản phẩm";
        String START_SIZE = "Số trang phải bắt đầu từ 0";

        String FOMAT_FILTER_DATE = "Thời gian phải theo định dạng 'dd/MM/yyyy' ví dụ: 22/02/2020";

        String CREATE_CATEGORY_FAIL = "Tạo mới danh mục  không thành công";
        String UPDATE_CATEGORY_FAIL = "Cập nhật danh mục  không thành công";
        String TITLE_NOT_BLANK = "Tiêu đề không được để trống";
        String TITLE_SIZE = "Tiêu đề không được quá 200 ký tự";
        String SLUG_NOT_BLANK = "Đường dẫn không được để trống";
        String DESCRIPTION_SIZE = "Mô tả không được quá 2000 ký tự";

    }

    interface ErrorMessagePostValidation {
        String POST_UPDATE_FALSE_USERID = "Bạn không được thay đổi bài viết này!";
        String POST_DELETE_FALSE_USERID = "Có một số bài viết bạn không được quyền xóa!";
        String TITLE_NOT_SPECIAL_CHARATERS = "Tiêu đề không được có ký tự đặc biệt";
        String SLUG_NOT_SPECIAL_CHARATERS = "Đường dẫn chỉ nhận ký tự đặc biệt (-)";
        String TITLE_NOT_BLANK = "Tiêu đề không được để trống";
        String SLUG_NOT_BLANK = "Đương dẫn không được để trống";
        String DESCRIPTION_NOT_BLANK = "Giới thiệu không được để trống";
        String CONTENT_NOT_BLANK = "Nội dung không được để trống";
        String STATE_NOT_BLANK = "Trạng thái không được để trống";
        String STATE_VALIDATE = "Trạng thái chỉ có 2 trường hợp: ACTIVE, INACTIVE";
        String TITLE_SIZE = "Tiêu đề không được quá 200 ký tự";
        String SLUG_SIZE = "Đương dẫn không được quá 200 ký tự";
        String DESCRIPTION_SIZE = "Giới thiệu không được quá 500 ký tự";
        String CONTENT_SIZE = "Nội dung không được quá 5000 ký tự";
        String LIMIT_SIZE = "Số lượng bài viết trong một trang là từ 5 đến 50 bài viết";
        String START_SIZE = "Số trang phải bắt đầu từ 0";
        String NOT_FIND_POST_BY_ID = "Không tìm thây bài viết có ID là: ";
        String NOT_FIND_POST_BY_SLUG = "Không tìm thây bài viết có đường dẫn là: ";
        String FOMAT_FILTER_DATE = "Thời gian phải theo định dạng 'dd/MM/yyyy' ví dụ: 22/02/2020";
        String CREATE_POST_FAIL = "Tạo mới bài viết không thành công";
        String UPDATE_POST_FAIL = "Cập nhật bài viết không thành công";
        String DELETE_NOT_EMPTY = "Vui lòng truyền id tin tức cần xóa";
        String SLUG_UNIQUE = "Đường dẫn: %s đã được sử dụng";
    }

    interface SortType {
        String DESC = "DESC";
        String ASC = "ASC";
    }

    interface PostState {
        int ACTIVE = 1;
        int IN_ACTIVE = 2;

    }

    interface DateTimeFormatConstant {
        String DATE_TIME_FORMAT = "dd/MM/yyyy HH:mm:ss";
        String DATE_FORMAT = "dd/MM/yyyy";
        String TIME_ZONE = "Asia/Ho_Chi_Minh";
    }

    interface HeaderConstant {
        String HEADER_USER_ID = "X-USER-ID";
    }

}