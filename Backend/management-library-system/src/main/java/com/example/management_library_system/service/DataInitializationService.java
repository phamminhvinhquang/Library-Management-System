package com.example.management_library_system.service;

import com.example.management_library_system.model.Author;
import com.example.management_library_system.model.Book;
import com.example.management_library_system.model.Category;
import com.example.management_library_system.repository.AuthorRepository;
import com.example.management_library_system.repository.BookRepository;
import com.example.management_library_system.repository.CategoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;

@Service
public class DataInitializationService implements CommandLineRunner {

    private final BookRepository bookRepository;
    private final CategoryRepository categoryRepository;
    private final AuthorRepository authorRepository;

    public DataInitializationService(BookRepository bookRepository, 
                                     CategoryRepository categoryRepository, 
                                     AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.categoryRepository = categoryRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        // thể loại
        Category c1 = new Category(); c1.setCateName("Lịch Sử - Quân Sự");
        Category c2 = new Category(); c2.setCateName("Tâm Lý Kỹ Năng");
        Category c3 = new Category(); c3.setCateName("Giáo Dục Đào Tạo");
        Category c4 = new Category(); c4.setCateName("Thư Viện Pháp Luật");
        Category c5 = new Category(); c5.setCateName("Công Nghệ Thông Tin");
        categoryRepository.saveAll(Arrays.asList(c1, c2, c3, c4, c5));

        //Category c1
        Author a1 = new Author(); a1.setAuthorName("Nguyễn Khắc Thuần");
        Author a2 = new Author(); a2.setAuthorName("Yuval Noah Harari");
        Author a3 = new Author(); a3.setAuthorName("La Quán Trung");
        Author a4 = new Author(); a4.setAuthorName("Yu Dan");
        Author a5 = new Author(); a5.setAuthorName("Eugene Sue");
        Author a6 = new Author(); a6.setAuthorName("Trần Trọng Kim");
        Author a7 = new Author(); a7.setAuthorName("Sơn Tùng");
        Author a8 = new Author(); a8.setAuthorName("Lưu Hướng");

        //Category c2
        Author a9 = new Author(); a9.setAuthorName("Đồng Linh");
        Author a10 = new Author(); a10.setAuthorName("Cal Newport");
        Author a11 = new Author(); a11.setAuthorName("Thu Giang");
        Author a12 = new Author(); a12.setAuthorName("Cao Minh");
        Author a13 = new Author(); a13.setAuthorName("Robert Greene");
        Author a14 = new Author(); a14.setAuthorName(" Dương Thu Ái");
        Author a15 = new Author(); a15.setAuthorName("Nguyễn Duy Cần");

        //Category c3
        Author a16 = new Author(); a16.setAuthorName("Hoàng Nhật Minh");
        Author a17 = new Author(); a17.setAuthorName("Nguyễn Viết Thông");
        Author a18 = new Author(); a18.setAuthorName("Lê Thái Bình");
        Author a19 = new Author(); a19.setAuthorName("Phan Thị Kim Ngân");
        Author a20 = new Author(); a20.setAuthorName("Học Viện Úc Châu");

        Author a21 = new Author(); a21.setAuthorName("Thích Nhật Quang");

        //Category c4
        Author a22 = new Author(); a22.setAuthorName("Nhiều Tác Giả");
        Author a23 = new Author(); a23.setAuthorName("Trần Việt Dũng");
        Author a24 = new Author(); a24.setAuthorName("Nguyễn Thị Kim Oanh");
        Author a25 = new Author(); a25.setAuthorName(" Lê Minh Toàn");
        Author a26 = new Author(); a26.setAuthorName(" Trần Ngọc Hà");

        //Category c5
        Author a27 = new Author(); a27.setAuthorName("Ajay Agrawal");
        Author a28 = new Author(); a28.setAuthorName("Lê Đức Long");
        Author a29 = new Author(); a29.setAuthorName("Paul Vigna");

        authorRepository.saveAll(Arrays.asList(a1, a2, a3, a4, a6, a7, a8, a5, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18, a19, a20, a21, a22, a23, a24, a25, a26, a27, a28, a29));

        //Category c1
        Book b1 = new Book();
        b1.setBookName("DANH TƯỚNG VIỆT NAM");
        b1.setPublisher("Giáo Dục");
        b1.setYearPublish(2005);
        b1.setQuantity(8);
        b1.setBorrowCount(45);
        // #region Book Detail
        b1.setBookDetail("Cuốn sách giới thiệu về các vị danh tướng lẫy lừng của lịch sử Việt Nam.\n" + 
                 "Chương 1: Danh tướng thời buổi đầu dựng nước và giữ nước\n"+
                 "Chương 2: Danh tướng thời Ngô, Đinh và Tiền Lê\n"+
                 "Chương 3: Danh tướng thời Lý\n"+
                 "Chương 4: Phụ lục và tư liệu\n"+ 
                 "1. Mục đích của cuốn sách\n" + //
                                          "\n" + //
                                          "Nguyễn Khắc Thuần mong muốn:\n" + //
                                          "\n" + //
                                          "Giới thiệu những danh tướng tiêu biểu của dân tộc bằng góc nhìn lịch sử khách quan.\n" + //
                                          "Làm nổi bật truyền thống yêu nước và nghệ thuật quân sự Việt Nam.\n" + //
                                          "Giúp người đọc hiểu rằng chiến thắng của dân tộc không chỉ nhờ các vị vua mà còn nhờ rất nhiều danh tướng tài năng.\n" + //
                                          "2. Giai đoạn đầu giành độc lập (thế kỷ X)\n" + //
                                          "Dương Đình Nghệ\n" + //
                                          "Là người đặt nền móng cho việc khôi phục nền tự chủ sau hơn một nghìn năm Bắc thuộc.\n" + //
                                          "Đánh đuổi quân Nam Hán khỏi Đại La.\n" + //
                                          "Đào tạo nhiều nhân tài, trong đó nổi bật nhất là Ngô Quyền.\n" + //
                                          "\n" + //
                                          "Ý nghĩa: Nếu không có Dương Đình Nghệ, rất khó có chiến thắng Bạch Đằng sau này.\n" + //
                                          "\n" + //
                                          "Ngô Quyền\n" + //
                                          "Đánh bại quân Nam Hán năm 938 trên sông Bạch Đằng.\n" + //
                                          "Sử dụng trận địa cọc gỗ kết hợp thủy triều.\n" + //
                                          "Kết thúc hơn một thiên niên kỷ Bắc thuộc.\n" + //
                                          "Thành lập nhà Ngô.\n" + //
                                          "\n" + //
                                          "Bài học quân sự\n" + //
                                          "\n" + //
                                          "Biết tận dụng địa hình.\n" + //
                                          "Chủ động chọn chiến trường.\n" + //
                                          "Đánh vào điểm yếu của đối phương.\n" + //
                                          "Đinh Bộ Lĩnh\n" + //
                                          "Dẹp loạn 12 sứ quân.\n" + //
                                          "Thống nhất đất nước.\n" + //
                                          "Lập nước Đại Cồ Việt.\n" + //
                                          "\n" + //
                                          "Đóng góp lớn nhất của ông là xây dựng quốc gia thống nhất sau nhiều năm chia cắt.\n" + //
                                          "\n" + //
                                          "Lê Hoàn\n" + //
                                          "Lên ngôi khi đất nước bị đe dọa.\n" + //
                                          "Đánh bại quân Tống xâm lược năm 981.\n" + //
                                          "Ổn định triều Tiền Lê.\n" + //
                                          "\n" + //
                                          "Tác giả đánh giá ông là người biết kết hợp ngoại giao với quân sự.\n" + //
                                          "\n" + //
                                          "3. Thời nhà Lý\n" + //
                                          "\n" + //
                                          "Đây là giai đoạn Đại Việt phát triển mạnh và hình thành nhiều tư tưởng quân sự đặc sắc.\n" + //
                                          "\n" + //
                                          "Lý Thường Kiệt\n" + //
                                          "\n" + //
                                          "Là nhân vật được dành nhiều dung lượng nhất.\n" + //
                                          "\n" + //
                                          "Ông:\n" + //
                                          "\n" + //
                                          "Chủ trương \"tiên phát chế nhân\" (đánh trước để tự vệ).\n" + //
                                          "Đem quân đánh vào Ung Châu, Khâm Châu, Liêm Châu của nhà Tống.\n" + //
                                          "Chỉ huy cuộc kháng chiến 1075–1077.\n" + //
                                          "Xây dựng phòng tuyến sông Như Nguyệt.\n" + //
                                          "\n" + //
                                          "Đặc biệt:\n" + //
                                          "\n" + //
                                          "Bài thơ Nam quốc sơn hà được xem như bản tuyên ngôn độc lập đầu tiên.\n" + //
                                          "\n" + //
                                          "Tác giả đánh giá Lý Thường Kiệt là một trong những thiên tài quân sự xuất sắc nhất lịch sử Việt Nam.\n" + //
                                          "\n" + //
                                          "4. Thời Trần\n" + //
                                          "\n" + //
                                          "Đây là phần lớn nhất của tập sách.\n" + //
                                          "\n" + //
                                          "Ba lần kháng chiến chống quân Nguyên – Mông được xem là đỉnh cao nghệ thuật quân sự Việt Nam.\n" + //
                                          "\n" + //
                                          "Trần Quốc Tuấn (Hưng Đạo Vương)\n" + //
                                          "\n" + //
                                          "Là trung tâm của cuốn sách.\n" + //
                                          "\n" + //
                                          "Ông:\n" + //
                                          "\n" + //
                                          "Tổng chỉ huy cả ba cuộc kháng chiến.\n" + //
                                          "Viết Hịch tướng sĩ.\n" + //
                                          "Biên soạn Binh thư yếu lược.\n" + //
                                          "Xây dựng chiến lược \"vườn không nhà trống\".\n" + //
                                          "Chủ động rút lui để bảo toàn lực lượng.\n" + //
                                          "Phản công đúng thời cơ.\n" + //
                                          "\n" + //
                                          "Chiến thắng tiêu biểu:\n" + //
                                          "\n" + //
                                          "Bạch Đằng năm 1288.\n" + //
                                          "\n" + //
                                          "Theo tác giả, Trần Hưng Đạo là danh tướng kiệt xuất nhất của lịch sử quân sự Việt Nam.\n" + //
                                          "\n" + //
                                          "Trần Quang Khải\n" + //
                                          "Chỉ huy nhiều trận đánh lớn.\n" + //
                                          "Chiến thắng Chương Dương.\n" + //
                                          "Giải phóng kinh thành Thăng Long.\n" + //
                                          "\n" + //
                                          "Ông vừa là nhà quân sự vừa là nhà ngoại giao.\n" + //
                                          "\n" + //
                                          "Trần Nhật Duật\n" + //
                                          "Giỏi ngoại giao với các dân tộc miền núi.\n" + //
                                          "Hiểu nhiều ngôn ngữ.\n" + //
                                          "Thu phục lòng người.\n" + //
                                          "Góp phần giữ vững khối đoàn kết quốc gia.\n" + //
                                          "Trần Khánh Dư\n" + //
                                          "Chỉ huy trận Vân Đồn.\n" + //
                                          "Tiêu diệt đoàn thuyền lương của quân Nguyên.\n" + //
                                          "Khiến quân Nguyên rơi vào tình trạng thiếu lương thực.\n" + //
                                          "\n" + //
                                          "Tác giả xem đây là một chiến thắng mang tính quyết định.\n" + //
                                          "\n" + //
                                          "Phạm Ngũ Lão\n" + //
                                          "Xuất thân bình dân.\n" + //
                                          "Nổi tiếng với lòng trung thành và tài cầm quân.\n" + //
                                          "Tham gia cả ba cuộc kháng chiến chống Nguyên.\n" + //
                                          "\n" + //
                                          "Ông trở thành biểu tượng của người anh hùng xuất thân từ nhân dân.\n" + //
                                          "\n" + //
                                          "Các danh tướng khác\n" + //
                                          "\n" + //
                                          "Ngoài những nhân vật nổi tiếng, sách còn giới thiệu nhiều tướng lĩnh như:\n" + //
                                          "\n" + //
                                          "Trần Bình Trọng\n" + //
                                          "Yết Kiêu\n" + //
                                          "Dã Tượng\n" + //
                                          "Nguyễn Khoái\n" + //
                                          "Trần Quốc Toản\n" + //
                                          "Và nhiều võ tướng khác góp phần tạo nên chiến thắng thời Trần.\n" + //
                                          "5. Những tư tưởng lớn của cuốn sách\n" + //
                                          "\n" + //
                                          "Qua các danh tướng, tác giả rút ra nhiều bài học:\n" + //
                                          "\n" + //
                                          "Lấy dân làm gốc.\n" + //
                                          "Đoàn kết toàn dân.\n" + //
                                          "Linh hoạt trong chiến lược.\n" + //
                                          "Biết tận dụng địa hình.\n" + //
                                          "Không đánh theo lối đối đầu trực diện khi bất lợi.\n" + //
                                          "Kết hợp quân sự với ngoại giao.\n" + //
                                          "Người lãnh đạo phải đặt lợi ích quốc gia lên trên lợi ích cá nhân.\n" + //
                                          "6. Giá trị của cuốn sách\n" + //
                                          "\n" + //
                                          "Cuốn sách không chỉ là tập hợp tiểu sử các danh tướng mà còn là một công trình nghiên cứu lịch sử quân sự. Nguyễn Khắc Thuần sử dụng nhiều nguồn sử liệu để phân tích bối cảnh, chiến thuật và phẩm chất của từng nhân vật, giúp người đọc hiểu vì sao một quốc gia nhỏ như Đại Việt nhiều lần chiến thắng các đế chế hùng mạnh.");
        // #endregion
        b1.setCategory(c1);
        b1.setAuthors(new ArrayList<>(Arrays.asList(a1)));
        // Sử dụng ảnh từ folder static của project (Cách 1)
        b1.setCoverImage("/images/7203-danh-tuong-viet-nam-1.webp"); 
        bookRepository.save(b1);

        Book b2 = new Book();
        b2.setBookName("SAPIENS - LƯỢC SỬ LOÀI NGƯỜI");
        b2.setPublisher("Thời Đại");
        b2.setYearPublish(2021);
        b2.setQuantity(20);
        b2.setBorrowCount(1);
        // #region Book Detail
        b2.setBookDetail("SAPIENS – LƯỢC SỬ LOÀI NGƯỜI\n" + //
                        "\n" + //
                        "Tác giả: Yuval Noah Harari\n" + //
                        "\n" + //
                        "Giới thiệu\n" + //
                        "\n" + //
                        "Sapiens – Lược sử loài người là một trong những cuốn sách lịch sử nổi tiếng nhất thế giới. Cuốn sách kể lại hành trình khoảng 300.000 năm của loài người, từ khi Homo sapiens xuất hiện ở châu Phi cho đến thời đại trí tuệ nhân tạo và công nghệ sinh học. Thay vì chỉ kể các sự kiện lịch sử, tác giả giải thích vì sao con người trở thành loài thống trị Trái Đất.\n" + //
                        "\n" + //
                        "Cấu trúc sách\n" + //
                        "\n" + //
                        "Cuốn sách gồm Lời mở đầu, 4 phần chính và 20 chương.\n" + //
                        "\n" + //
                        "Lời mở đầu\n" + //
                        "Một loài vật tầm thường\n" + //
                        "Khoảng 300.000 năm trước, Homo sapiens chỉ là một trong nhiều loài người.\n" + //
                        "Chúng ta không mạnh hơn sư tử, nhanh hơn báo hay to lớn hơn voi.\n" + //
                        "\n" + //
                        "Câu hỏi lớn của tác giả:\n" + //
                        "\n" + //
                        "Vì sao Homo sapiens lại thống trị thế giới?\n" + //
                        "\n" + //
                        "PHẦN I: CUỘC CÁCH MẠNG NHẬN THỨC\n" + //
                        "\n" + //
                        "(Khoảng 70.000 năm trước)\n" + //
                        "\n" + //
                        "Chương 1. Một loài vật vô nghĩa\n" + //
                        "\n" + //
                        "Nội dung:\n" + //
                        "\n" + //
                        "Giới thiệu các loài người:\n" + //
                        "Homo habilis\n" + //
                        "Homo erectus\n" + //
                        "Homo neanderthalensis\n" + //
                        "Homo sapiens\n" + //
                        "Homo sapiens ban đầu không có gì nổi bật.\n" + //
                        "Ý chính\n" + //
                        "\n" + //
                        "Con người chỉ là một động vật trong hệ sinh thái.\n" + //
                        "\n" + //
                        "Chương 2. Cây tri thức\n" + //
                        "\n" + //
                        "Khoảng 70.000 năm trước xảy ra Cuộc Cách mạng Nhận thức.\n" + //
                        "\n" + //
                        "Con người bắt đầu:\n" + //
                        "\n" + //
                        "sử dụng ngôn ngữ phức tạp\n" + //
                        "tưởng tượng\n" + //
                        "kể chuyện\n" + //
                        "truyền đạt kiến thức\n" + //
                        "Đây là bước ngoặt lớn nhất.\n" + //
                        "\n" + //
                        "Ví dụ:\n" + //
                        "\n" + //
                        "Con người có thể cùng tin vào:\n" + //
                        "\n" + //
                        "quốc gia\n" + //
                        "thần linh\n" + //
                        "pháp luật\n" + //
                        "tiền\n" + //
                        "doanh nghiệp\n" + //
                        "\n" + //
                        "Mặc dù chúng không tồn tại dưới dạng vật chất.\n" + //
                        "\n" + //
                        "Chương 3. Một ngày trong đời Adam và Eve\n" + //
                        "\n" + //
                        "Miêu tả đời sống săn bắt hái lượm.\n" + //
                        "\n" + //
                        "Con người:\n" + //
                        "\n" + //
                        "ăn đa dạng\n" + //
                        "ít bệnh mãn tính\n" + //
                        "làm việc ít giờ\n" + //
                        "sống gần thiên nhiên\n" + //
                        "\n" + //
                        "Theo tác giả, đây có thể là thời kỳ hạnh phúc nhất.\n" + //
                        "\n" + //
                        "Chương 4. Trận đại hồng thủy\n" + //
                        "\n" + //
                        "Khi con người lan khắp thế giới:\n" + //
                        "\n" + //
                        "voi ma mút biến mất\n" + //
                        "hổ răng kiếm tuyệt chủng\n" + //
                        "hàng nghìn loài động vật bị tiêu diệt\n" + //
                        "\n" + //
                        "Con người trở thành sinh vật gây tuyệt chủng hàng loạt đầu tiên.\n" + //
                        "\n" + //
                        "PHẦN II: CUỘC CÁCH MẠNG NÔNG NGHIỆP\n" + //
                        "\n" + //
                        "(Khoảng 12.000 năm trước)\n" + //
                        "\n" + //
                        "Chương 5. Trò lừa lớn nhất lịch sử\n" + //
                        "\n" + //
                        "Con người bắt đầu:\n" + //
                        "\n" + //
                        "trồng lúa\n" + //
                        "trồng lúa mì\n" + //
                        "nuôi gia súc\n" + //
                        "\n" + //
                        "Harari cho rằng:\n" + //
                        "\n" + //
                        "Nông nghiệp không làm con người hạnh phúc hơn.\n" + //
                        "\n" + //
                        "Nó khiến:\n" + //
                        "\n" + //
                        "làm việc nhiều hơn\n" + //
                        "ăn uống kém đa dạng\n" + //
                        "bệnh tật tăng\n" + //
                        "chiến tranh nhiều hơn\n" + //
                        "Chương 6. Xây dựng kim tự tháp\n" + //
                        "\n" + //
                        "Các xã hội lớn hình thành.\n" + //
                        "\n" + //
                        "Xuất hiện:\n" + //
                        "\n" + //
                        "tầng lớp\n" + //
                        "vua\n" + //
                        "luật pháp\n" + //
                        "thuế\n" + //
                        "quân đội\n" + //
                        "Chương 7. Trí nhớ quá tải\n" + //
                        "\n" + //
                        "Con người phát minh:\n" + //
                        "\n" + //
                        "chữ viết\n" + //
                        "số học\n" + //
                        "sổ sách\n" + //
                        "\n" + //
                        "Nhờ đó mới quản lý được hàng triệu người.\n" + //
                        "\n" + //
                        "Chương 8. Không có công lý trong lịch sử\n" + //
                        "\n" + //
                        "Tác giả phân tích:\n" + //
                        "\n" + //
                        "phân biệt giàu nghèo\n" + //
                        "nô lệ\n" + //
                        "nam nữ\n" + //
                        "chủng tộc\n" + //
                        "\n" + //
                        "Ông cho rằng nhiều bất bình đẳng là sản phẩm của xã hội.\n" + //
                        "\n" + //
                        "PHẦN III: SỰ THỐNG NHẤT CỦA LOÀI NGƯỜI\n" + //
                        "Chương 9. Mũi tên lịch sử\n" + //
                        "\n" + //
                        "Lịch sử luôn tiến tới sự thống nhất.\n" + //
                        "\n" + //
                        "Ví dụ:\n" + //
                        "\n" + //
                        "đế quốc\n" + //
                        "thương mại\n" + //
                        "tôn giáo\n" + //
                        "Chương 10. Mùi hương của tiền\n" + //
                        "\n" + //
                        "Tiền là:\n" + //
                        "\n" + //
                        "Hệ thống niềm tin thành công nhất lịch sử.\n" + //
                        "\n" + //
                        "Một tờ tiền chỉ có giá trị vì mọi người cùng tin vào nó.\n" + //
                        "\n" + //
                        "Chương 11. Những viễn cảnh đế quốc\n" + //
                        "\n" + //
                        "Các đế quốc:\n" + //
                        "\n" + //
                        "La Mã\n" + //
                        "Ba Tư\n" + //
                        "Trung Hoa\n" + //
                        "Anh\n" + //
                        "\n" + //
                        "vừa xâm lược vừa truyền bá:\n" + //
                        "\n" + //
                        "văn hóa\n" + //
                        "luật pháp\n" + //
                        "khoa học\n" + //
                        "Chương 12. Quy luật của tôn giáo\n" + //
                        "\n" + //
                        "Phân tích:\n" + //
                        "\n" + //
                        "Phật giáo\n" + //
                        "Kitô giáo\n" + //
                        "Hồi giáo\n" + //
                        "Ấn Độ giáo\n" + //
                        "\n" + //
                        "Tôn giáo giúp hàng triệu người hợp tác.\n" + //
                        "\n" + //
                        "Chương 13. Bí mật của thành công\n" + //
                        "\n" + //
                        "Lịch sử nhân loại là lịch sử:\n" + //
                        "\n" + //
                        "trao đổi văn hóa\n" + //
                        "học hỏi\n" + //
                        "tiếp nhận cái mới\n" + //
                        "PHẦN IV: CUỘC CÁCH MẠNG KHOA HỌC\n" + //
                        "Chương 14. Phát hiện ra sự ngu dốt\n" + //
                        "\n" + //
                        "Khoảng năm 1500.\n" + //
                        "\n" + //
                        "Con người bắt đầu thừa nhận:\n" + //
                        "\n" + //
                        "Chúng ta chưa biết tất cả.\n" + //
                        "\n" + //
                        "Đó là khởi đầu của khoa học hiện đại.\n" + //
                        "\n" + //
                        "Chương 15. Hôn nhân giữa khoa học và đế quốc\n" + //
                        "\n" + //
                        "Các đế quốc tài trợ:\n" + //
                        "\n" + //
                        "địa lý\n" + //
                        "thiên văn\n" + //
                        "y học\n" + //
                        "hàng hải\n" + //
                        "\n" + //
                        "để mở rộng thuộc địa.\n" + //
                        "\n" + //
                        "Chương 16. Tín ngưỡng tư bản\n" + //
                        "\n" + //
                        "Chủ nghĩa tư bản dựa trên:\n" + //
                        "\n" + //
                        "tín dụng\n" + //
                        "đầu tư\n" + //
                        "tăng trưởng\n" + //
                        "\n" + //
                        "Harari cho rằng:\n" + //
                        "\n" + //
                        "niềm tin vào tương lai là nền tảng của kinh tế hiện đại.\n" + //
                        "\n" + //
                        "Chương 17. Bánh xe của công nghiệp\n" + //
                        "\n" + //
                        "Máy móc thay thế sức người.\n" + //
                        "\n" + //
                        "Xuất hiện:\n" + //
                        "\n" + //
                        "nhà máy\n" + //
                        "điện\n" + //
                        "động cơ\n" + //
                        "đường sắt\n" + //
                        "Chương 18. Cuộc cách mạng thường trực\n" + //
                        "\n" + //
                        "Những thay đổi diễn ra nhanh chưa từng có.\n" + //
                        "\n" + //
                        "Con người liên tục thích nghi.\n" + //
                        "\n" + //
                        "Chương 19. Và họ sống hạnh phúc mãi mãi?\n" + //
                        "\n" + //
                        "Harari đặt câu hỏi:\n" + //
                        "\n" + //
                        "Con người giàu hơn,\n" + //
                        "\n" + //
                        "nhưng có thật sự hạnh phúc hơn không?\n" + //
                        "\n" + //
                        "Chương 20. Kết thúc của Homo sapiens\n" + //
                        "\n" + //
                        "Đây là chương nổi tiếng nhất.\n" + //
                        "\n" + //
                        "Tác giả nói về:\n" + //
                        "\n" + //
                        "trí tuệ nhân tạo\n" + //
                        "công nghệ sinh học\n" + //
                        "chỉnh sửa gene\n" + //
                        "con người nâng cấp (Homo Deus)\n" + //
                        "\n" + //
                        "Có thể trong tương lai:\n" + //
                        "\n" + //
                        "Homo sapiens sẽ biến mất\n" + //
                        "hoặc tiến hóa thành loài khác.\n" + //
                        "Những tư tưởng lớn của cuốn sách\n" + //
                        "1. Sức mạnh của trí tưởng tượng\n" + //
                        "\n" + //
                        "Con người thống trị thế giới vì biết cùng nhau tin vào:\n" + //
                        "\n" + //
                        "tiền\n" + //
                        "quốc gia\n" + //
                        "pháp luật\n" + //
                        "công ty\n" + //
                        "tôn giáo\n" + //
                        "2. Hợp tác quy mô lớn\n" + //
                        "\n" + //
                        "Loài người có thể hợp tác với hàng triệu người không quen biết.\n" + //
                        "\n" + //
                        "3. Nông nghiệp không hoàn toàn là tiến bộ\n" + //
                        "\n" + //
                        "Nông nghiệp giúp dân số tăng,\n" + //
                        "\n" + //
                        "nhưng không chắc làm cuộc sống từng cá nhân tốt hơn.\n" + //
                        "\n" + //
                        "4. Khoa học thay đổi mọi thứ\n" + //
                        "\n" + //
                        "Thừa nhận \"mình chưa biết\"\n" + //
                        "\n" + //
                        "là nền tảng của mọi tiến bộ.\n" + //
                        "\n" + //
                        "5. Tương lai rất khó đoán\n" + //
                        "\n" + //
                        "AI, công nghệ gene và robot có thể làm thay đổi định nghĩa về \"con người\".\n" + //
                        "\n" + //
                        "Giá trị của cuốn sách\n" + //
                        "\n" + //
                        "Cuốn sách giúp người đọc:\n" + //
                        "\n" + //
                        "Hiểu lịch sử nhân loại dưới góc nhìn liên ngành, kết hợp lịch sử, sinh học, khảo cổ và kinh tế.\n" + //
                        "Nhận ra vai trò của các \"câu chuyện chung\" (quốc gia, tiền tệ, luật pháp...) trong việc tạo nên xã hội hiện đại.\n" + //
                        "Suy ngẫm về tác động của khoa học và công nghệ đối với tương lai của loài người.");
         // #endregion
        b2.setCategory(c1); 
        b2.setAuthors(new ArrayList<>(Arrays.asList(a2)));
        b2.setCoverImage("/images/1695-sapiens-luoc-su-loai-nguoi-1.webp");
        bookRepository.save(b2);

        Book b3 = new Book();
        b3.setBookName("TAM QUỐC DIỄN NGHĨA");
        b3.setPublisher("VĂN HỌC ĐÔNG A");
        b3.setYearPublish(2019);
        b3.setQuantity(12);
        b3.setBorrowCount(2);
        // #region Book Detail  
        b3.setBookDetail("Tam Quốc Diễn Nghĩa – Tóm tắt và các chương (120 hồi)\n" + //
                        "\n" + //
                        "Tam Quốc Diễn Nghĩa là một trong Tứ đại danh tác của văn học Trung Quốc, do La Quán Trung biên soạn vào khoảng thế kỷ XIV. Tác phẩm gồm 120 hồi (chương), kể về thời kỳ cuối nhà Đông Hán đến khi nhà Tấn thống nhất Trung Hoa (khoảng năm 169–280). Nội dung kết hợp giữa lịch sử và hư cấu văn học.\n" + //
                        "\n" + //
                        "Tóm tắt toàn bộ tác phẩm\n" + //
                        "\n" + //
                        "Cuối thời Đông Hán, triều đình mục nát, hoạn quan lộng quyền, nhân dân nổi dậy trong Khởi nghĩa Khăn Vàng. Trong thời loạn xuất hiện ba anh hùng:\n" + //
                        "\n" + //
                        "Lưu Bị\n" + //
                        "Quan Vũ\n" + //
                        "Trương Phi\n" + //
                        "\n" + //
                        "Ba người kết nghĩa vườn đào và cùng phò nhà Hán.\n" + //
                        "\n" + //
                        "Sau đó, Đổng Trác thao túng triều đình, gây ra chiến loạn. Các chư hầu nổi dậy nhưng nhanh chóng chia rẽ, tranh giành quyền lực.\n" + //
                        "\n" + //
                        "Ba thế lực lớn dần hình thành:\n" + //
                        "\n" + //
                        "Ngụy do Tào Tháo xây dựng.\n" + //
                        "Thục do Lưu Bị thành lập.\n" + //
                        "Ngô do Tôn Quyền cai trị.\n" + //
                        "\n" + //
                        "Đỉnh cao của tác phẩm là Trận Xích Bích, khi liên minh Thục – Ngô đánh bại đại quân của Tào Tháo, tạo nên thế chân vạc Tam Quốc.\n" + //
                        "\n" + //
                        "Sau đó:\n" + //
                        "\n" + //
                        "Gia Cát Lượng giúp Lưu Bị xây dựng nước Thục.\n" + //
                        "Quan Vũ thất thủ Kinh Châu và bị giết.\n" + //
                        "Lưu Bị đánh Ngô để báo thù nhưng đại bại ở Di Lăng.\n" + //
                        "Gia Cát Lượng nhiều lần Bắc phạt nhưng không thống nhất được thiên hạ.\n" + //
                        "\n" + //
                        "Về sau:\n" + //
                        "\n" + //
                        "Họ Tư Mã dần nắm quyền nước Ngụy.\n" + //
                        "Tư Mã Viêm lập ra nhà Tấn.\n" + //
                        "Nhà Tấn lần lượt diệt Thục và Ngô, thống nhất Trung Hoa, kết thúc thời kỳ Tam Quốc.\n" + //
                        "Bố cục 120 hồi\n" + //
                        "Phần 1 (Hồi 1–33): Cuối nhà Đông Hán\n" + //
                        "\n" + //
                        "Nội dung chính\n" + //
                        "\n" + //
                        "Khởi nghĩa Khăn Vàng.\n" + //
                        "Kết nghĩa vườn đào.\n" + //
                        "Đổng Trác chuyên quyền.\n" + //
                        "Lã Bố phản Đổng Trác.\n" + //
                        "Tào Tháo bắt đầu gây dựng thế lực.\n" + //
                        "Lưu Bị nhiều lần thất bại.\n" + //
                        "Viên Thiệu và Tào Tháo đối đầu.\n" + //
                        "\n" + //
                        "Các hồi nổi bật\n" + //
                        "\n" + //
                        "Hồi 1: Kết nghĩa vườn đào.\n" + //
                        "Hồi 5: Ba anh hùng đánh Lã Bố.\n" + //
                        "Hồi 19: Lã Bố bị bắt và xử tử.\n" + //
                        "Hồi 21: Tào Tháo luận anh hùng với Lưu Bị.\n" + //
                        "Phần 2 (Hồi 34–50): Hình thành thế chân vạc\n" + //
                        "\n" + //
                        "Nội dung chính\n" + //
                        "\n" + //
                        "Lưu Bị ba lần đến lều tranh mời Gia Cát Lượng.\n" + //
                        "Gia Cát Lượng xuất sơn.\n" + //
                        "Chu Du liên minh với Lưu Bị.\n" + //
                        "Đại chiến Xích Bích.\n" + //
                        "\n" + //
                        "Các hồi nổi bật\n" + //
                        "\n" + //
                        "Tam cố thảo lư.\n" + //
                        "Mượn gió Đông.\n" + //
                        "Thuyền cỏ mượn tên.\n" + //
                        "Chu Du đánh Xích Bích.\n" + //
                        "Phần 3 (Hồi 51–85): Ba nước Ngụy – Thục – Ngô\n" + //
                        "\n" + //
                        "Nội dung chính\n" + //
                        "\n" + //
                        "Lưu Bị chiếm Ích Châu.\n" + //
                        "Quan Vũ trấn giữ Kinh Châu.\n" + //
                        "Quan Vũ đại thắng Tương Dương.\n" + //
                        "Quan Vũ thất thủ Mạch Thành.\n" + //
                        "Lưu Bị xưng đế.\n" + //
                        "Trận Di Lăng.\n" + //
                        "\n" + //
                        "Các hồi nổi bật\n" + //
                        "\n" + //
                        "Hồi 73: Lưu Bị xưng Hán Trung Vương.\n" + //
                        "Hồi 74: Quan Vũ dìm bảy đạo quân.\n" + //
                        "Hồi 76–77: Quan Vũ mất Kinh Châu.\n" + //
                        "Hồi 81–84: Lưu Bị thua trận Di Lăng.\n" + //
                        "Phần 4 (Hồi 86–104): Gia Cát Lượng Bắc phạt\n" + //
                        "\n" + //
                        "Nội dung chính\n" + //
                        "\n" + //
                        "Gia Cát Lượng phò Lưu Thiện.\n" + //
                        "Thất cầm Mạnh Hoạch.\n" + //
                        "Sáu lần Bắc phạt.\n" + //
                        "Đấu trí với Tư Mã Ý.\n" + //
                        "Gia Cát Lượng mất tại gò Ngũ Trượng.\n" + //
                        "\n" + //
                        "Các hồi nổi bật\n" + //
                        "\n" + //
                        "Không thành kế.\n" + //
                        "Mộc ngưu lưu mã.\n" + //
                        "Lục xuất Kỳ Sơn.\n" + //
                        "Gia Cát Lượng qua đời.\n" + //
                        "Phần 5 (Hồi 105–120): Kết thúc Tam Quốc\n" + //
                        "\n" + //
                        "Nội dung chính\n" + //
                        "\n" + //
                        "Khương Duy tiếp tục Bắc phạt.\n" + //
                        "Họ Tư Mã cướp quyền nhà Ngụy.\n" + //
                        "Thục bị diệt.\n" + //
                        "Đông Ngô suy yếu.\n" + //
                        "Nhà Tấn thống nhất thiên hạ.\n" + //
                        "\n" + //
                        "Các hồi cuối\n" + //
                        "\n" + //
                        "Hồi 117: Đặng Ngải đánh vào Thục.\n" + //
                        "Hồi 118: Lưu Thiện đầu hàng.\n" + //
                        "Hồi 119: Nhà Ngụy mất.\n" + //
                        "Hồi 120: Nhà Tấn diệt Ngô, thống nhất Trung Hoa.");
        // #endregion
        b3.setCategory(c1);
        b3.setAuthors(new ArrayList<>(Arrays.asList(a3)));
        b3.setCoverImage("/images/1005-tam-quoc-dien-nghia-1.webp");
        bookRepository.save(b3);

        Book b4 = new Book();
        b4.setBookName("TRANG TỬ TÂM ĐẮC");
        b4.setPublisher("Trẻ");
        b4.setYearPublish(2022);
        b4.setQuantity(12);
        b4.setBorrowCount(2);
        // #region Book Detail
        b4.setBookDetail("Trang Tử Tâm Đắc – Tóm tắt và các chương\n" + //
                        "\n" + //
                        "Trang Tử Tâm Đắc là tác phẩm của Yu Dan, diễn giải tư tưởng trong Nam Hoa Kinh (hay Trang Tử) của Trang Tử theo góc nhìn hiện đại. Cuốn sách không phải là bản dịch nguyên tác mà là sách bình giải, giúp người đọc áp dụng triết lý Đạo gia vào cuộc sống ngày nay. Tác phẩm đã bán hàng triệu bản tại Trung Quốc và được dịch ra nhiều ngôn ngữ.\n" + //
                        "\n" + //
                        "Tóm tắt nội dung toàn sách\n" + //
                        "\n" + //
                        "Cuốn sách tập trung trả lời câu hỏi:\n" + //
                        "\n" + //
                        "Làm thế nào để sống bình an và tự do giữa một thế giới đầy cạnh tranh, áp lực và biến động?\n" + //
                        "\n" + //
                        "Theo Yu Dan, tư tưởng của Trang Tử không dạy con người trốn tránh cuộc đời mà giúp chúng ta:\n" + //
                        "\n" + //
                        "Biết rõ bản thân.\n" + //
                        "Không bị danh lợi chi phối.\n" + //
                        "Thuận theo quy luật tự nhiên.\n" + //
                        "Chấp nhận sinh – tử như một phần của cuộc sống.\n" + //
                        "Giữ tâm hồn tự do trước mọi biến cố.\n" + //
                        "\n" + //
                        "Thông qua những câu chuyện ngụ ngôn nổi tiếng của Trang Tử, tác giả giải thích cách đạt đến sự an nhiên, tiêu dao, và hài hòa với tự nhiên.\n" + //
                        "\n" + //
                        "Mục lục và tóm tắt các chương\n" + //
                        "\n" + //
                        "Theo các ấn bản tiếng Việt hiện nay, sách gồm phần giới thiệu và 10 chương chính.\n" + //
                        "\n" + //
                        "Lời giới thiệu\n" + //
                        "\n" + //
                        "Giới thiệu cuộc đời của Trang Tử, hoàn cảnh lịch sử thời Chiến Quốc và giá trị của Nam Hoa Kinh. Tác giả giải thích vì sao tư tưởng của Trang Tử vẫn còn ý nghĩa đối với con người hiện đại.\n" + //
                        "\n" + //
                        "Chương 1. Trang Tử là người như thế nào\n" + //
                        "\n" + //
                        "Nội dung\n" + //
                        "\n" + //
                        "Cuộc đời giản dị của Trang Tử.\n" + //
                        "Tinh thần tự do.\n" + //
                        "Không chạy theo quyền lực và danh vọng.\n" + //
                        "\n" + //
                        "Thông điệp\n" + //
                        "\n" + //
                        "Con người chỉ thật sự tự do khi không để vật chất và địa vị quyết định giá trị của mình.\n" + //
                        "\n" + //
                        "Chương 2. Tầm vóc có lớn có nhỏ\n" + //
                        "\n" + //
                        "Nội dung\n" + //
                        "\n" + //
                        "Câu chuyện chim Bằng và chim Sẻ.\n" + //
                        "Mỗi người có cách sống và tầm nhìn khác nhau.\n" + //
                        "\n" + //
                        "Thông điệp\n" + //
                        "\n" + //
                        "Không nên dùng tiêu chuẩn của mình để đánh giá người khác.\n" + //
                        "\n" + //
                        "Chương 3. Cảm ngộ và vượt qua\n" + //
                        "\n" + //
                        "Nội dung\n" + //
                        "\n" + //
                        "Đối diện thất bại.\n" + //
                        "Đối diện đau khổ.\n" + //
                        "Biết buông bỏ.\n" + //
                        "\n" + //
                        "Thông điệp\n" + //
                        "\n" + //
                        "Khó khăn là cơ hội để trưởng thành nếu biết thay đổi góc nhìn.\n" + //
                        "\n" + //
                        "Chương 4. Nhận thức chính mình\n" + //
                        "\n" + //
                        "Nội dung\n" + //
                        "\n" + //
                        "Hiểu bản thân.\n" + //
                        "Không sống theo kỳ vọng của người khác.\n" + //
                        "\n" + //
                        "Thông điệp\n" + //
                        "\n" + //
                        "Người hiểu mình sẽ ít bị ngoại cảnh làm dao động.\n" + //
                        "\n" + //
                        "Chương 5. Luôn có đường để đi\n" + //
                        "\n" + //
                        "Nội dung\n" + //
                        "\n" + //
                        "Mọi hoàn cảnh đều có lối thoát.\n" + //
                        "Quan trọng là cách nhìn nhận.\n" + //
                        "\n" + //
                        "Thông điệp\n" + //
                        "\n" + //
                        "Thay đổi tư duy sẽ mở ra con đường mới.\n" + //
                        "\n" + //
                        "Chương 6. Nói cười luận sinh ngữ\n" + //
                        "\n" + //
                        "Nội dung\n" + //
                        "\n" + //
                        "Quan niệm của Trang Tử về sinh tử.\n" + //
                        "Những câu chuyện mang tính hài hước nhưng sâu sắc.\n" + //
                        "\n" + //
                        "Thông điệp\n" + //
                        "\n" + //
                        "Sinh và tử đều là quy luật tự nhiên; hiểu điều đó giúp con người bớt sợ hãi.\n" + //
                        "\n" + //
                        "Chương 7. Kiên trì và thuận theo\n" + //
                        "\n" + //
                        "Nội dung\n" + //
                        "\n" + //
                        "Kiên định với điều đúng.\n" + //
                        "Đồng thời biết thuận theo quy luật của tự nhiên.\n" + //
                        "\n" + //
                        "Thông điệp\n" + //
                        "\n" + //
                        "Không phải lúc nào cố gắng nhiều hơn cũng tốt; đôi khi cần biết buông và thích nghi.\n" + //
                        "\n" + //
                        "Chương 8. Bản tính và ngộ tính\n" + //
                        "\n" + //
                        "Nội dung\n" + //
                        "\n" + //
                        "Bản chất con người.\n" + //
                        "Khả năng giác ngộ.\n" + //
                        "\n" + //
                        "Thông điệp\n" + //
                        "\n" + //
                        "Mỗi người đều có tiềm năng phát triển nếu biết quay về với bản tính chân thật.\n" + //
                        "\n" + //
                        "Chương 9. Tâm thái và trạng thái\n" + //
                        "\n" + //
                        "Nội dung\n" + //
                        "\n" + //
                        "Giữ tâm bình an.\n" + //
                        "Không để cảm xúc tiêu cực chi phối.\n" + //
                        "\n" + //
                        "Thông điệp\n" + //
                        "\n" + //
                        "Hạnh phúc phụ thuộc nhiều vào tâm thái hơn là hoàn cảnh.\n" + //
                        "\n" + //
                        "Chương 10. Đạo lớn và tự nhiên\n" + //
                        "\n" + //
                        "Nội dung\n" + //
                        "\n" + //
                        "Khái niệm \"Đạo\".\n" + //
                        "Sống thuận theo tự nhiên.\n" + //
                        "Tự do nội tâm.\n" + //
                        "\n" + //
                        "Thông điệp\n" + //
                        "\n" + //
                        "Đỉnh cao của trí tuệ là sống hòa hợp với tự nhiên, không cưỡng cầu, không tranh đoạt.");
        // #endregion
        b4.setCategory(c1);
        b4.setAuthors(new ArrayList<>(Arrays.asList(a4)));
        b4.setCoverImage("/images/901-trang-tu-tam-dac-1.webp");
        bookRepository.save(b4);

        Book b5 = new Book();
        b5.setBookName("BÍ MẬT THÀNH PARIS");
        b5.setPublisher("Hội Nhà Văn");
        b5.setYearPublish(2020);
        b5.setQuantity(25);
        b5.setBorrowCount(3);
        // #region Book Detail 
        b5.setBookDetail("Bí Mật Thành Paris – Tóm tắt và các phần chính\n" + //
                        "\n" + //
                        "Bí Mật Thành Paris (Les Mystères de Paris) là tiểu thuyết nổi tiếng của Eugène Sue, được đăng nhiều kỳ từ năm 1842–1843. Đây là một trong những tác phẩm đặt nền móng cho dòng tiểu thuyết xã hội và trinh thám – phiêu lưu của văn học Pháp. Tác phẩm khắc họa bức tranh toàn cảnh về Paris thế kỷ XIX, từ giới quý tộc đến tầng lớp nghèo khổ và tội phạm.\n" + //
                        "\n" + //
                        "Tóm tắt toàn bộ tác phẩm\n" + //
                        "\n" + //
                        "Nhân vật trung tâm là Rodolphe, một Đại công tước xứ Gerolstein. Mang mặc cảm vì những sai lầm trong quá khứ, ông cải trang thành người bình dân để sống giữa những khu ổ chuột của Paris.\n" + //
                        "\n" + //
                        "Trong hành trình ấy, Rodolphe:\n" + //
                        "\n" + //
                        "Giải cứu những người vô tội.\n" + //
                        "Trừng trị những kẻ phạm tội.\n" + //
                        "Điều tra nhiều âm mưu và bí mật.\n" + //
                        "Khám phá sự thật về thân phận của nhiều nhân vật.\n" + //
                        "\n" + //
                        "Người quan trọng nhất ông gặp là Sơn Ca (Fleur-de-Marie), một cô gái mồ côi sống trong cảnh cơ cực. Rodolphe cứu cô khỏi bọn lưu manh, nhưng cuộc đời Sơn Ca vẫn liên tiếp gặp bi kịch trước khi một bí mật về thân thế của cô được hé lộ.\n" + //
                        "\n" + //
                        "Bố cục của bộ sách\n" + //
                        "\n" + //
                        "Ấn bản tiếng Việt thường được chia thành 5 tập, với hàng trăm chương và nhiều phần nhỏ.\n" + //
                        "\n" + //
                        "Tập 1 – Bước vào thế giới ngầm Paris\n" + //
                        "\n" + //
                        "Nội dung chính\n" + //
                        "\n" + //
                        "Rodolphe cải trang thành người nghèo.\n" + //
                        "Gặp Sơn Ca.\n" + //
                        "Đụng độ băng nhóm tội phạm.\n" + //
                        "Khám phá cuộc sống trong các khu ổ chuột.\n" + //
                        "\n" + //
                        "Một số chương tiêu biểu\n" + //
                        "\n" + //
                        "Sơn Ca\n" + //
                        "Chọc Tiết\n" + //
                        "Tom và Sara\n" + //
                        "Cuộc đi dạo\n" + //
                        "Trang trại\n" + //
                        "Hình phạt\n" + //
                        "\n" + //
                        "Đây là phần giới thiệu các nhân vật và bức tranh xã hội Paris đầy bất công.\n" + //
                        "\n" + //
                        "Tập 2 – Những số phận đan xen\n" + //
                        "\n" + //
                        "Nội dung chính\n" + //
                        "\n" + //
                        "Rodolphe tiếp tục giúp đỡ người nghèo.\n" + //
                        "Xuất hiện thêm nhiều nhân vật mới.\n" + //
                        "Hé lộ các mối quan hệ phức tạp.\n" + //
                        "Các âm mưu bắt đầu rõ nét.\n" + //
                        "\n" + //
                        "Một số chương nổi bật\n" + //
                        "\n" + //
                        "Nhà cha xứ\n" + //
                        "Giấc mơ\n" + //
                        "Lòng từ thiện\n" + //
                        "Cảnh khốn cùng\n" + //
                        "Món nợ\n" + //
                        "Louise\n" + //
                        "Rigolette\n" + //
                        "\n" + //
                        "Phần này đào sâu vào hoàn cảnh của từng nhân vật và sự đối lập giữa lòng tốt với lòng tham.\n" + //
                        "\n" + //
                        "Tập 3 – Những bí mật được hé mở\n" + //
                        "\n" + //
                        "Nội dung chính\n" + //
                        "\n" + //
                        "Rodolphe truy tìm Jacques Ferrand.\n" + //
                        "Nhiều bí mật gia đình dần được tiết lộ.\n" + //
                        "Các nhân vật phải đối mặt với lựa chọn giữa thiện và ác.\n" + //
                        "\n" + //
                        "Các chương xoay quanh:\n" + //
                        "\n" + //
                        "Những lời khuyên\n" + //
                        "Âm mưu\n" + //
                        "Điều tra\n" + //
                        "Những cuộc đối đầu\n" + //
                        "\n" + //
                        "Đây là phần đẩy cao yếu tố điều tra và tâm lý.\n" + //
                        "\n" + //
                        "Tập 4 – Cuộc chiến giữa công lý và tội ác\n" + //
                        "\n" + //
                        "Nội dung chính\n" + //
                        "\n" + //
                        "Rodolphe đối đầu trực diện với những thế lực tội phạm.\n" + //
                        "Các kế hoạch trả thù và chuộc lỗi diễn ra.\n" + //
                        "Nhiều nhân vật nhận lấy hậu quả từ hành động của mình.\n" + //
                        "\n" + //
                        "Chủ đề chính là công lý, sự tha thứ và trách nhiệm.\n" + //
                        "\n" + //
                        "Tập 5 – Kết thúc\n" + //
                        "\n" + //
                        "Nội dung chính\n" + //
                        "\n" + //
                        "Những bí mật cuối cùng được giải đáp.\n" + //
                        "Rodolphe đối đầu các kẻ chủ mưu.\n" + //
                        "Số phận của Sơn Ca được khép lại.\n" + //
                        "Thiện và ác đều nhận kết cục tương xứng.\n" + //
                        "\n" + //
                        "Một số chương đáng chú ý:\n" + //
                        "\n" + //
                        "Những tên đồng lõa\n" + //
                        "Rodolphe và Sarah\n" + //
                        "Trả thù\n" + //
                        "\n" + //
                        "Đây là phần kết thúc mọi tuyến truyện và hoàn thiện hành trình chuộc lỗi của Rodolphe.");
        // #endregion
        b5.setCategory(c1);
        b5.setAuthors(new ArrayList<>(Arrays.asList(a5)));
        b5.setCoverImage("/images/6085-bi-mat-thanh-paris-tap-1-1.webp");
        bookRepository.save(b5);

        Book b6 = new Book();
        b6.setBookName("VIỆT NAM SỬ LƯỢC");
        b6.setPublisher("Văn Hóa Thông Tin");
        b6.setYearPublish(2008);
        b6.setQuantity(30);
        b6.setBorrowCount(4);
        // #region Book Detail 
        b6.setBookDetail("Việt Nam Sử Lược – Tóm tắt và các chương\n" + //
                        "\n" + //
                        "Việt Nam sử lược là bộ thông sử đầu tiên được viết bằng chữ Quốc ngữ, do học giả Trần Trọng Kim biên soạn và xuất bản lần đầu năm 1920. Tác phẩm trình bày lịch sử Việt Nam từ thời Hồng Bàng đến đầu thế kỷ XX, với văn phong ngắn gọn, mạch lạc và dễ tiếp cận.\n" + //
                        "\n" + //
                        "Tóm tắt toàn bộ tác phẩm\n" + //
                        "\n" + //
                        "Cuốn sách thuật lại quá trình hình thành và phát triển của dân tộc Việt Nam qua hơn hai nghìn năm lịch sử:\n" + //
                        "\n" + //
                        "Thời kỳ dựng nước của các vua Hùng.\n" + //
                        "Thời kỳ Bắc thuộc và các cuộc đấu tranh giành độc lập.\n" + //
                        "Các triều đại phong kiến độc lập như Ngô, Đinh, Tiền Lê, Lý, Trần, Hồ, Hậu Lê, Mạc, Tây Sơn và Nguyễn.\n" + //
                        "Quá trình thực dân Pháp xâm lược Việt Nam.\n" + //
                        "Tình hình đất nước dưới chế độ bảo hộ của Pháp đầu thế kỷ XX.\n" + //
                        "\n" + //
                        "Bên cạnh việc ghi chép các sự kiện, tác giả còn phân tích nguyên nhân hưng thịnh và suy vong của từng triều đại, rút ra những bài học về chính trị, quân sự và đạo đức trị quốc.\n" + //
                        "\n" + //
                        "Bố cục và tóm tắt các phần\n" + //
                        "\n" + //
                        "Toàn bộ sách gồm 5 phần lớn với 53 chương, ngoài ra còn có phần Tựa, Tổng kết và Niên biểu.\n" + //
                        "\n" + //
                        "Phần I. Thượng cổ thời đại (4 chương)\n" + //
                        "\n" + //
                        "Các chương\n" + //
                        "\n" + //
                        "Họ Hồng Bàng\n" + //
                        "Nhà Thục\n" + //
                        "Xã hội nước Tàu\n" + //
                        "Nhà Triệu\n" + //
                        "Nội dung\n" + //
                        "\n" + //
                        "Phần này trình bày:\n" + //
                        "\n" + //
                        "Truyền thuyết Lạc Long Quân – Âu Cơ.\n" + //
                        "Nhà nước Văn Lang.\n" + //
                        "Nhà nước Âu Lạc.\n" + //
                        "An Dương Vương xây thành Cổ Loa.\n" + //
                        "Triệu Đà thôn tính Âu Lạc.\n" + //
                        "\n" + //
                        "Đây là giai đoạn hình thành dân tộc và nền văn minh đầu tiên của người Việt.\n" + //
                        "\n" + //
                        "Phần II. Bắc thuộc thời đại (6 chương)\n" + //
                        "\n" + //
                        "Các chương\n" + //
                        "\n" + //
                        "Bắc thuộc lần thứ nhất\n" + //
                        "Trưng Vương\n" + //
                        "Bắc thuộc lần thứ hai\n" + //
                        "Nhà Tiền Lý\n" + //
                        "Bắc thuộc lần thứ ba\n" + //
                        "Kết quả của thời Bắc thuộc\n" + //
                        "Nội dung\n" + //
                        "\n" + //
                        "Kéo dài gần một nghìn năm với các sự kiện nổi bật:\n" + //
                        "\n" + //
                        "Hai Bà Trưng khởi nghĩa.\n" + //
                        "Bà Triệu chống Ngô.\n" + //
                        "Lý Bí lập nước Vạn Xuân.\n" + //
                        "Các cuộc nổi dậy chống ách đô hộ phương Bắc.\n" + //
                        "Hình thành ý thức dân tộc và khát vọng độc lập.\n" + //
                        "\n" + //
                        "Phần III. Tự chủ thời đại (Thời kỳ thống nhất) – 15 chương\n" + //
                        "\n" + //
                        "Các chương chính\n" + //
                        "\n" + //
                        "Nhà Ngô\n" + //
                        "Nhà Đinh\n" + //
                        "Nhà Tiền Lê\n" + //
                        "Nhà Lý\n" + //
                        "Nhà Trần\n" + //
                        "Nhà Hồ\n" + //
                        "Nhà Hậu Trần\n" + //
                        "Thuộc Minh\n" + //
                        "Mười năm khởi nghĩa Lam Sơn\n" + //
                        "Nhà Lê\n" + //
                        "Nội dung\n" + //
                        "\n" + //
                        "Đây là phần dài và quan trọng nhất của sách.\n" + //
                        "\n" + //
                        "Các sự kiện tiêu biểu:\n" + //
                        "\n" + //
                        "Ngô Quyền chiến thắng Bạch Đằng năm 938.\n" + //
                        "Đinh Bộ Lĩnh thống nhất đất nước.\n" + //
                        "Triều Lý xây dựng quốc gia Đại Việt hùng mạnh.\n" + //
                        "Nhà Trần ba lần đánh bại quân Nguyên – Mông.\n" + //
                        "Nhà Hồ cải cách đất nước.\n" + //
                        "Nhà Minh đô hộ.\n" + //
                        "Lê Lợi lãnh đạo khởi nghĩa Lam Sơn và lập nhà Hậu Lê.\n" + //
                        "\n" + //
                        "Đây được xem là thời kỳ phát triển rực rỡ của chế độ phong kiến Việt Nam.\n" + //
                        "\n" + //
                        "Phần IV. Tự chủ thời đại (Nam – Bắc phân tranh) – 12 chương\n" + //
                        "\n" + //
                        "Các chương\n" + //
                        "\n" + //
                        "Lịch triều lược kỷ\n" + //
                        "Nam triều – Bắc triều\n" + //
                        "Trịnh Nguyễn phân tranh\n" + //
                        "Công việc họ Trịnh\n" + //
                        "Công việc họ Nguyễn\n" + //
                        "Người Âu châu sang nước Nam\n" + //
                        "Nhà Tây Sơn\n" + //
                        "Nguyễn Vương thống nhất đất nước\n" + //
                        "Nội dung\n" + //
                        "\n" + //
                        "Phần này trình bày:\n" + //
                        "\n" + //
                        "Nhà Mạc cướp ngôi.\n" + //
                        "Chiến tranh Nam – Bắc triều.\n" + //
                        "Chiến tranh Trịnh – Nguyễn kéo dài.\n" + //
                        "Người châu Âu bắt đầu đến Việt Nam.\n" + //
                        "Khởi nghĩa Tây Sơn.\n" + //
                        "Nguyễn Huệ đánh tan quân Thanh.\n" + //
                        "Nguyễn Ánh thống nhất đất nước và lập triều Nguyễn.\n" + //
                        "\n" + //
                        "Phần V. Cận kim thời đại (16 chương)\n" + //
                        "\n" + //
                        "Các chương\n" + //
                        "\n" + //
                        "Gia Long\n" + //
                        "Minh Mạng\n" + //
                        "Thiệu Trị\n" + //
                        "Tự Đức\n" + //
                        "Nước Pháp chiếm Nam Kỳ\n" + //
                        "Đánh chiếm Bắc Kỳ\n" + //
                        "Chiến tranh với nhà Thanh\n" + //
                        "Chế độ bảo hộ\n" + //
                        "Tình hình Việt Nam đầu thế kỷ XX\n" + //
                        "Nội dung\n" + //
                        "\n" + //
                        "Đây là phần mô tả:\n" + //
                        "\n" + //
                        "Sự phát triển và cải cách dưới triều Nguyễn.\n" + //
                        "Những khó khăn của triều đình.\n" + //
                        "Thực dân Pháp từng bước xâm lược Việt Nam.\n" + //
                        "Hiệp ước bảo hộ.\n" + //
                        "Việt Nam trở thành thuộc địa của Pháp.\n" + //
                        "Những biến đổi về chính trị, xã hội và kinh tế đầu thế kỷ XX.");
        // #endregion
        b6.setCategory(c1);
        b6.setAuthors(new ArrayList<>(Arrays.asList(a6)));
        b6.setCoverImage("/images/1748-viet-nam-su-luoc-1.webp");
        bookRepository.save(b6);

        Book b7 = new Book();
        b7.setBookName("BÚP SEN XANH");
        b7.setPublisher(" Kim Đồng");
        b7.setYearPublish(2008);
        b7.setQuantity(10);
        b7.setBorrowCount(4);
        // #region Book Detail
        b7.setBookDetail("Búp Sen Xanh – Tóm tắt và các phần chính\n" + //
                        "\n" + //
                        "Búp Sen Xanh là tiểu thuyết lịch sử nổi tiếng của Sơn Tùng, xuất bản lần đầu năm 1982. Đây là tác phẩm tiêu biểu viết về thời niên thiếu của Chủ tịch Hồ Chí Minh, tái hiện cuộc đời từ khi sinh ra tại làng Chùa (quê ngoại) đến lúc rời Bến Nhà Rồng năm 1911 để ra đi tìm đường cứu nước. Tác phẩm được xây dựng trên cơ sở nhiều năm sưu tầm tư liệu lịch sử kết hợp với nghệ thuật tiểu thuyết.\n" + //
                        "\n" + //
                        "Tóm tắt toàn bộ tác phẩm\n" + //
                        "\n" + //
                        "Cuốn sách kể về tuổi thơ và tuổi trẻ của Nguyễn Sinh Cung (Nguyễn Tất Thành) trong bối cảnh đất nước bị thực dân Pháp đô hộ.\n" + //
                        "\n" + //
                        "Từ những năm tháng sống ở quê hương Nghệ An, cậu bé Cung lớn lên trong tình yêu thương của mẹ Hoàng Thị Loan, sự dạy dỗ nghiêm khắc của cha Nguyễn Sinh Sắc, và truyền thống hiếu học của gia đình.\n" + //
                        "\n" + //
                        "Sau khi mẹ qua đời, gia đình trải qua nhiều biến cố. Nguyễn Tất Thành theo cha vào Huế, tiếp xúc với hiện thực xã hội, chứng kiến cảnh nhân dân lầm than và sự bất lực của triều đình phong kiến. Những trải nghiệm ấy dần hình thành trong ông lòng yêu nước và khát vọng tìm con đường giải phóng dân tộc.\n" + //
                        "\n" + //
                        "Tác phẩm kết thúc bằng hình ảnh Nguyễn Tất Thành chia tay quê hương, lên tàu tại Bến Nhà Rồng ngày 5/6/1911 để bắt đầu hành trình tìm đường cứu nước.\n" + //
                        "\n" + //
                        "Bố cục và tóm tắt các phần\n" + //
                        "\n" + //
                        "Tùy từng lần tái bản, số chương và cách chia có khác nhau. Các bản in hiện đại thường chia thành nhiều chương nhỏ, nhưng nội dung có thể khái quát thành 6 phần lớn.\n" + //
                        "\n" + //
                        "Phần 1. Tuổi thơ ở quê ngoại và quê nội\n" + //
                        "\n" + //
                        "Nội dung\n" + //
                        "\n" + //
                        "Nguyễn Sinh Cung chào đời tại làng Chùa (quê ngoại).\n" + //
                        "Tuổi thơ ở làng Sen (quê nội).\n" + //
                        "Cuộc sống giản dị của gia đình.\n" + //
                        "Tình yêu thương của mẹ và sự dạy dỗ của cha.\n" + //
                        "\n" + //
                        "Ý nghĩa\n" + //
                        "\n" + //
                        "Hình thành những phẩm chất đầu tiên: hiếu học, nhân hậu, yêu quê hương.\n" + //
                        "\n" + //
                        "Phần 2. Những năm tháng học tập\n" + //
                        "\n" + //
                        "Nội dung\n" + //
                        "\n" + //
                        "Học chữ Hán và chữ Quốc ngữ.\n" + //
                        "Kết bạn với nhiều bạn bè.\n" + //
                        "Chịu ảnh hưởng từ truyền thống hiếu học của gia đình.\n" + //
                        "Chứng kiến cảnh nghèo khó của người dân.\n" + //
                        "\n" + //
                        "Ý nghĩa\n" + //
                        "\n" + //
                        "Nuôi dưỡng tinh thần ham học hỏi và ý thức về trách nhiệm đối với đất nước.\n" + //
                        "\n" + //
                        "Phần 3. Biến cố gia đình\n" + //
                        "\n" + //
                        "Nội dung\n" + //
                        "\n" + //
                        "Mẹ Hoàng Thị Loan qua đời.\n" + //
                        "Cha Nguyễn Sinh Sắc tiếp tục con đường khoa cử.\n" + //
                        "Gia đình nhiều lần chuyển nơi ở.\n" + //
                        "Nguyễn Sinh Cung sớm trưởng thành trước những mất mát.\n" + //
                        "\n" + //
                        "Ý nghĩa\n" + //
                        "\n" + //
                        "Những đau thương trong gia đình góp phần rèn luyện nghị lực và ý chí.\n" + //
                        "\n" + //
                        "Phần 4. Những năm ở Huế\n" + //
                        "\n" + //
                        "Nội dung\n" + //
                        "\n" + //
                        "Theo cha vào Huế.\n" + //
                        "Học tập trong môi trường mới.\n" + //
                        "Quan sát đời sống quan lại và nhân dân.\n" + //
                        "Chứng kiến sự bất công của xã hội dưới ách thực dân.\n" + //
                        "\n" + //
                        "Ý nghĩa\n" + //
                        "\n" + //
                        "Đây là giai đoạn tư tưởng yêu nước của Nguyễn Tất Thành phát triển rõ nét.\n" + //
                        "\n" + //
                        "Phần 5. Khát vọng cứu nước\n" + //
                        "\n" + //
                        "Nội dung\n" + //
                        "\n" + //
                        "Tiếp xúc với nhiều nhà yêu nước và các phong trào đương thời.\n" + //
                        "Nhận thấy những con đường cứu nước cũ chưa mang lại thành công.\n" + //
                        "Quyết tâm tìm một con đường mới cho dân tộc.\n" + //
                        "\n" + //
                        "Ý nghĩa\n" + //
                        "\n" + //
                        "Hình thành lý tưởng lớn lao vì độc lập dân tộc.\n" + //
                        "\n" + //
                        "Phần 6. Ra đi tìm đường cứu nước\n" + //
                        "\n" + //
                        "Nội dung\n" + //
                        "\n" + //
                        "Chia tay gia đình và quê hương.\n" + //
                        "Đến Sài Gòn.\n" + //
                        "Làm việc trên tàu buôn.\n" + //
                        "Ngày 5/6/1911 rời Bến Nhà Rồng.\n" + //
                        "\n" + //
                        "Ý nghĩa\n" + //
                        "\n" + //
                        "Khép lại tuổi trẻ và mở đầu hành trình tìm con đường giải phóng dân tộc kéo dài nhiều năm.");
        // #endregion
        b7.setCategory(c1);
        b7.setAuthors(new ArrayList<>(Arrays.asList(a7)));
        b7.setCoverImage("/images/7278-bup-sen-xanh-1.webp");
        bookRepository.save(b7);

        Book b8 = new Book();
        b8.setBookName("LIỆT NỮ TRUYỆN");
        b8.setPublisher(" Hồng Đức");
        b8.setYearPublish(2008);
        b8.setQuantity(10);
        b8.setBorrowCount(6);
        // #region Book Detail
        b8.setBookDetail("Liệt Nữ Truyện – Tóm tắt và các chương\n" + //
                        "\n" + //
                        "Liệt Nữ Truyện (列女傳) là tác phẩm của Lưu Hướng, biên soạn vào khoảng năm 18 TCN dưới thời Hán Thành Đế. Đây là bộ sách tập hợp các câu chuyện về những người phụ nữ tiêu biểu trong lịch sử Trung Quốc cổ đại nhằm giáo hóa về đạo đức, phẩm hạnh và cách ứng xử theo quan điểm Nho gia. Bản lưu truyền ngày nay gồm 7 thiên (quyển) với khoảng 105 nhân vật, về sau có thêm Tục Liệt Nữ Truyện do các học giả đời sau biên soạn.\n" + //
                        "\n" + //
                        "Tóm tắt toàn bộ tác phẩm\n" + //
                        "\n" + //
                        "Liệt Nữ Truyện không kể một câu chuyện xuyên suốt mà là tập hợp nhiều truyện ngắn về các phụ nữ nổi bật trong lịch sử từ thời cổ đại đến trước thời Tây Hán.\n" + //
                        "\n" + //
                        "Mỗi truyện kể về một người phụ nữ với một phẩm chất tiêu biểu như:\n" + //
                        "\n" + //
                        "Đức hạnh của người mẹ.\n" + //
                        "Trí tuệ và tài năng.\n" + //
                        "Lòng trung thành.\n" + //
                        "Sự chính trực.\n" + //
                        "Đức hy sinh.\n" + //
                        "Khả năng biện luận.\n" + //
                        "Hoặc ngược lại, những người phụ nữ bị xem là nguyên nhân dẫn đến suy vong của quốc gia.\n" + //
                        "\n" + //
                        "Qua đó, tác giả mong muốn dùng những tấm gương tốt và xấu để giáo dục đạo đức và cảnh tỉnh người cầm quyền.\n" + //
                        "\n" + //
                        "Bố cục của tác phẩm\n" + //
                        "\n" + //
                        "Nguyên tác được chia thành 7 thiên (quyển).\n" + //
                        "\n" + //
                        "Thiên 1. Mẫu Nghi (母儀)\n" + //
                        "\n" + //
                        "Nội dung\n" + //
                        "\n" + //
                        "Giới thiệu những người mẹ tiêu biểu.\n" + //
                        "\n" + //
                        "Các nhân vật nổi tiếng gồm:\n" + //
                        "\n" + //
                        "Mẹ của Mạnh Tử (câu chuyện Mạnh mẫu ba lần dời nhà).\n" + //
                        "Các hoàng hậu và mẫu thân biết giáo dục con cái.\n" + //
                        "\n" + //
                        "Thông điệp\n" + //
                        "\n" + //
                        "Người mẹ có vai trò quyết định trong việc hình thành nhân cách của con người.\n" + //
                        "\n" + //
                        "Thiên 2. Hiền Minh (賢明)\n" + //
                        "\n" + //
                        "Nội dung\n" + //
                        "\n" + //
                        "Ca ngợi những người phụ nữ:\n" + //
                        "\n" + //
                        "Có đức hạnh.\n" + //
                        "Biết giúp chồng trị nước.\n" + //
                        "Khuyên can vua và quan lại.\n" + //
                        "\n" + //
                        "Thông điệp\n" + //
                        "\n" + //
                        "Sự khôn ngoan và đức hạnh có thể góp phần làm cho quốc gia hưng thịnh.\n" + //
                        "\n" + //
                        "Thiên 3. Nhân Trí (仁智)\n" + //
                        "\n" + //
                        "Nội dung\n" + //
                        "\n" + //
                        "Kể về những phụ nữ:\n" + //
                        "\n" + //
                        "Nhân từ.\n" + //
                        "Có trí tuệ.\n" + //
                        "Biết nhìn xa trông rộng.\n" + //
                        "Đưa ra lời khuyên đúng lúc.\n" + //
                        "\n" + //
                        "Thông điệp\n" + //
                        "\n" + //
                        "Trí tuệ không chỉ thuộc về nam giới; nhiều phụ nữ đã góp phần thay đổi vận mệnh gia đình và đất nước.\n" + //
                        "\n" + //
                        "Thiên 4. Trinh Thuận (貞順)\n" + //
                        "\n" + //
                        "Nội dung\n" + //
                        "\n" + //
                        "Ca ngợi:\n" + //
                        "\n" + //
                        "Sự thủy chung.\n" + //
                        "Lòng trung trinh.\n" + //
                        "Đức hy sinh trong gia đình.\n" + //
                        "\n" + //
                        "Thông điệp\n" + //
                        "\n" + //
                        "Đề cao sự bền bỉ, giữ chữ tín và trách nhiệm trong hôn nhân theo quan niệm Nho giáo.\n" + //
                        "\n" + //
                        "Thiên 5. Tiết Nghĩa (節義)\n" + //
                        "\n" + //
                        "Nội dung\n" + //
                        "\n" + //
                        "Những người phụ nữ:\n" + //
                        "\n" + //
                        "Giữ trọn khí tiết.\n" + //
                        "Trung thành với chính nghĩa.\n" + //
                        "Dám hy sinh vì đạo nghĩa.\n" + //
                        "\n" + //
                        "Thông điệp\n" + //
                        "\n" + //
                        "Đạo nghĩa và khí tiết được đặt cao hơn lợi ích cá nhân.\n" + //
                        "\n" + //
                        "Thiên 6. Biện Thông (辯通)\n" + //
                        "\n" + //
                        "Nội dung\n" + //
                        "\n" + //
                        "Giới thiệu các phụ nữ:\n" + //
                        "\n" + //
                        "Giỏi ăn nói.\n" + //
                        "Có tài ngoại giao.\n" + //
                        "Biết dùng lý lẽ để hóa giải mâu thuẫn.\n" + //
                        "\n" + //
                        "Thông điệp\n" + //
                        "\n" + //
                        "Lời nói đúng lúc có thể cứu người, cứu nước và ngăn ngừa chiến tranh.\n" + //
                        "\n" + //
                        "Thiên 7. Nghiệt Bế (孽嬖)\n" + //
                        "\n" + //
                        "Nội dung\n" + //
                        "\n" + //
                        "Đây là thiên duy nhất mang tính phản diện.\n" + //
                        "\n" + //
                        "Các nhân vật nổi bật gồm:\n" + //
                        "\n" + //
                        "Muội Hỉ\n" + //
                        "Đát Kỷ\n" + //
                        "Bao Tự\n" + //
                        "\n" + //
                        "Theo quan điểm của tác giả, những người này là ví dụ về việc nhà vua mê đắm sắc đẹp, bỏ bê chính sự, dẫn đến quốc gia suy vong. Cách nhìn này phản ánh tư tưởng và chuẩn mực đạo đức của thời đại biên soạn sách, chứ không nhất thiết là kết luận của sử học hiện đại.\n" + //
                        "\n" + //
                        "Tục Liệt Nữ Truyện\n" + //
                        "\n" + //
                        "Các học giả đời sau bổ sung thêm Tục Liệt Nữ Truyện, ghi chép những phụ nữ tiêu biểu từ thời Tây Hán trở về sau, vẫn được phân loại theo các nhóm như Nhân Trí, Tiết Nghĩa, Hiền Minh, Biện Thông, Mẫu Nghi và Trinh Thuận.");
        // #endregion
        b8.setCategory(c1);
        b8.setAuthors(new ArrayList<>(Arrays.asList(a8)));
        b8.setCoverImage("/images/6257-liet-nu-truyen-1.webp");
        bookRepository.save(b8);

        //Category c2
        Book b9 = new Book();
        b9.setBookName("ĐẮC NHÂN TÂM");
        b9.setPublisher(" Văn Hóa");
        b9.setYearPublish(1999);
        b9.setQuantity(10);
        b9.setBorrowCount(1);
        // #region Book Detail
        b9.setBookDetail("Đắc Nhân Tâm – Tóm tắt và các chương\n" + //
                        "\n" + //
                        "Đắc Nhân Tâm (How to Win Friends and Influence People) là tác phẩm nổi tiếng của Dale Carnegie, xuất bản lần đầu năm 1936. Đây là một trong những cuốn sách kỹ năng giao tiếp và phát triển bản thân có ảnh hưởng lớn nhất thế giới, đã được dịch sang nhiều ngôn ngữ và bán hàng chục triệu bản. Nội dung sách hướng dẫn cách xây dựng các mối quan hệ, tạo thiện cảm, thuyết phục và lãnh đạo người khác bằng sự chân thành và thấu hiểu.\n" + //
                        "\n" + //
                        "Tóm tắt toàn bộ tác phẩm\n" + //
                        "\n" + //
                        "Đắc Nhân Tâm không dạy cách thao túng hay kiểm soát người khác. Thay vào đó, Dale Carnegie nhấn mạnh rằng muốn tạo ảnh hưởng, trước hết phải:\n" + //
                        "\n" + //
                        "Hiểu tâm lý con người.\n" + //
                        "Tôn trọng và chân thành với người khác.\n" + //
                        "Biết lắng nghe hơn là chỉ nói.\n" + //
                        "Khuyến khích thay vì chỉ trích.\n" + //
                        "Giúp người khác cảm thấy được coi trọng.\n" + //
                        "\n" + //
                        "Toàn bộ cuốn sách được xây dựng quanh 30 nguyên tắc, chia thành 4 phần lớn, từ nghệ thuật giao tiếp cơ bản đến cách lãnh đạo và tạo động lực cho người khác.\n" + //
                        "\n" + //
                        "Bố cục và tóm tắt các phần\n" + //
                        "Phần I. Ba nguyên tắc cơ bản trong ứng xử (3 chương)\n" + //
                        "Chương 1. Muốn lấy mật thì đừng phá tổ ong\n" + //
                        "\n" + //
                        "Nội dung\n" + //
                        "\n" + //
                        "Đừng chỉ trích.\n" + //
                        "Đừng lên án.\n" + //
                        "Đừng than phiền.\n" + //
                        "\n" + //
                        "Thông điệp\n" + //
                        "\n" + //
                        "Chỉ trích thường khiến người khác phòng thủ thay vì thay đổi.\n" + //
                        "\n" + //
                        "Chương 2. Bí mật lớn nhất trong phép ứng xử\n" + //
                        "\n" + //
                        "Nội dung\n" + //
                        "\n" + //
                        "Thành thật ghi nhận.\n" + //
                        "Khen ngợi đúng lúc.\n" + //
                        "Trân trọng người khác.\n" + //
                        "\n" + //
                        "Thông điệp\n" + //
                        "\n" + //
                        "Mọi người đều mong muốn được công nhận.\n" + //
                        "\n" + //
                        "Chương 3. Khơi gợi mong muốn nơi người khác\n" + //
                        "\n" + //
                        "Nội dung\n" + //
                        "\n" + //
                        "Hiểu điều người khác thật sự muốn.\n" + //
                        "Đề nghị theo hướng mang lại lợi ích cho họ.\n" + //
                        "\n" + //
                        "Thông điệp\n" + //
                        "\n" + //
                        "Muốn thuyết phục, hãy bắt đầu từ nhu cầu của đối phương.\n" + //
                        "\n" + //
                        "Phần II. Sáu cách tạo thiện cảm (6 chương)\n" + //
                        "Các chương chính\n" + //
                        "Thành thật quan tâm đến người khác.\n" + //
                        "Luôn mỉm cười.\n" + //
                        "Nhớ và gọi đúng tên người khác.\n" + //
                        "Biết lắng nghe.\n" + //
                        "Nói về điều người khác quan tâm.\n" + //
                        "Làm người khác cảm thấy họ quan trọng.\n" + //
                        "Nội dung\n" + //
                        "\n" + //
                        "Đây là phần nổi tiếng nhất của cuốn sách.\n" + //
                        "\n" + //
                        "Dale Carnegie cho rằng thiện cảm không đến từ tài ăn nói mà từ sự quan tâm chân thành và khả năng khiến người khác cảm thấy được tôn trọng.\n" + //
                        "\n" + //
                        "Phần III. Mười hai cách thuyết phục người khác (12 chương)\n" + //
                        "Những nguyên tắc nổi bật\n" + //
                        "Tránh tranh cãi.\n" + //
                        "Tôn trọng ý kiến người khác.\n" + //
                        "Nếu sai, hãy thừa nhận nhanh chóng.\n" + //
                        "Bắt đầu bằng thái độ thân thiện.\n" + //
                        "Để người khác nói nhiều hơn.\n" + //
                        "Đặt mình vào vị trí của người khác.\n" + //
                        "Kêu gọi những động cơ tốt đẹp.\n" + //
                        "Trình bày ý tưởng sinh động.\n" + //
                        "Khơi dậy tinh thần thử thách.\n" + //
                        "Nội dung\n" + //
                        "\n" + //
                        "Phần này giúp người đọc:\n" + //
                        "\n" + //
                        "Thuyết phục mà không áp đặt.\n" + //
                        "Giải quyết bất đồng hiệu quả.\n" + //
                        "Xây dựng sự đồng thuận thay vì đối đầu.\n" + //
                        "Phần IV. Chín nguyên tắc lãnh đạo và thay đổi người khác (9 chương)\n" + //
                        "Các nguyên tắc chính\n" + //
                        "Bắt đầu bằng lời khen chân thành.\n" + //
                        "Góp ý gián tiếp.\n" + //
                        "Nhìn nhận lỗi của mình trước khi phê bình người khác.\n" + //
                        "Gợi ý thay vì ra lệnh.\n" + //
                        "Giữ thể diện cho người khác.\n" + //
                        "Khuyến khích và động viên.\n" + //
                        "Giúp người khác tự hào về bản thân.\n" + //
                        "Tạo điều kiện để họ sửa sai.\n" + //
                        "Khiến người khác vui vẻ thực hiện điều bạn đề nghị.\n" + //
                        "Nội dung\n" + //
                        "\n" + //
                        "Phần cuối hướng đến vai trò của người lãnh đạo, quản lý hoặc bất kỳ ai muốn tạo ảnh hưởng tích cực. Trọng tâm là thay đổi hành vi của người khác mà vẫn giữ được sự tôn trọng và thiện chí.");
        // #endregion
        b9.setCategory(c2);
        b9.setAuthors(new ArrayList<>(Arrays.asList(a9)));
        b9.setCoverImage("/images/403-dac-nhan-tam-1.webp");
        bookRepository.save(b9);

        Book b10 = new Book();
        b10.setBookName("LÀM RA LÀM CHƠI RA CHƠI");
        b10.setPublisher("Thanh Niên");
        b10.setYearPublish(1999);
        b10.setQuantity(11);
        b10.setBorrowCount(1);
        // #region Book Detail
        b10.setBookDetail("Làm Ra Làm, Chơi Ra Chơi – Tóm tắt và các chương\n" + //
                        "\n" + //
                        "Làm Ra Làm, Chơi Ra Chơi (Work Clean: The Life-Changing Power of Mise-en-Place to Organize Your Life, Work, and Mind) là cuốn sách của Dan Charnas, xuất bản năm 2016. Tác giả giới thiệu triết lý Mise en Place – phương pháp tổ chức công việc của các đầu bếp chuyên nghiệp – và chỉ ra cách áp dụng nguyên tắc này vào học tập, công việc và cuộc sống hằng ngày. Trong tiếng Việt, sách thường được phát hành với nhan đề Làm Ra Làm, Chơi Ra Chơi.\n" + //
                        "\n" + //
                        "Tóm tắt toàn bộ tác phẩm\n" + //
                        "\n" + //
                        "Thông điệp trung tâm của cuốn sách là:\n" + //
                        "\n" + //
                        "Muốn làm việc hiệu quả, hãy chuẩn bị thật tốt trước khi bắt đầu.\n" + //
                        "\n" + //
                        "Theo Dan Charnas, các đầu bếp trong những nhà hàng bận rộn có thể phục vụ hàng trăm món ăn mỗi ngày không phải vì họ làm nhanh hơn người khác, mà vì:\n" + //
                        "\n" + //
                        "Chuẩn bị đầy đủ trước khi bắt đầu.\n" + //
                        "Sắp xếp mọi thứ theo trật tự.\n" + //
                        "Làm từng việc đúng thời điểm.\n" + //
                        "Luôn giữ không gian làm việc sạch sẽ.\n" + //
                        "Không để sự hỗn loạn làm giảm hiệu suất.\n" + //
                        "\n" + //
                        "Tác giả cho rằng những nguyên tắc này có thể áp dụng cho bất kỳ ngành nghề nào, từ sinh viên, nhân viên văn phòng đến nhà quản lý và doanh nhân.\n" + //
                        "\n" + //
                        "Bố cục và tóm tắt các chương\n" + //
                        "\n" + //
                        "Sách được xây dựng xoay quanh 10 nguyên tắc của Mise en Place. Tên chương có thể khác nhau đôi chút giữa các bản dịch, nhưng nội dung cốt lõi đều dựa trên các nguyên tắc sau.\n" + //
                        "\n" + //
                        "Chương 1. Chuẩn bị trước khi bắt đầu\n" + //
                        "\n" + //
                        "Nội dung\n" + //
                        "\n" + //
                        "Xác định mục tiêu.\n" + //
                        "Chuẩn bị đầy đủ công cụ.\n" + //
                        "Không bắt tay vào việc khi còn thiếu những thứ cần thiết.\n" + //
                        "\n" + //
                        "Bài học\n" + //
                        "\n" + //
                        "Chuẩn bị kỹ giúp giảm sai sót và tiết kiệm thời gian.\n" + //
                        "\n" + //
                        "Chương 2. Sắp xếp mọi thứ đúng vị trí\n" + //
                        "\n" + //
                        "Nội dung\n" + //
                        "\n" + //
                        "Mỗi vật dụng có một vị trí cố định.\n" + //
                        "Không mất thời gian tìm kiếm.\n" + //
                        "\n" + //
                        "Bài học\n" + //
                        "\n" + //
                        "Một không gian gọn gàng giúp đầu óc minh mẫn và tập trung hơn.\n" + //
                        "\n" + //
                        "Chương 3. Dọn dẹp liên tục\n" + //
                        "\n" + //
                        "Nội dung\n" + //
                        "\n" + //
                        "Không chờ đến cuối ngày mới dọn.\n" + //
                        "Làm sạch ngay trong quá trình làm việc.\n" + //
                        "\n" + //
                        "Bài học\n" + //
                        "\n" + //
                        "Sự ngăn nắp là một phần của hiệu quả, không phải việc làm thêm.\n" + //
                        "\n" + //
                        "Chương 4. Lập kế hoạch về thời gian\n" + //
                        "\n" + //
                        "Nội dung\n" + //
                        "\n" + //
                        "Chia nhỏ công việc.\n" + //
                        "Xác định thời điểm bắt đầu và kết thúc.\n" + //
                        "Tránh để nhiều việc dồn lại cùng lúc.\n" + //
                        "\n" + //
                        "Bài học\n" + //
                        "\n" + //
                        "Quản lý thời gian tốt quan trọng không kém làm việc chăm chỉ.\n" + //
                        "\n" + //
                        "Chương 5. Không làm nhiều việc cùng lúc\n" + //
                        "\n" + //
                        "Nội dung\n" + //
                        "\n" + //
                        "Tập trung vào một nhiệm vụ.\n" + //
                        "Hoàn thành rồi mới chuyển sang việc khác.\n" + //
                        "\n" + //
                        "Bài học\n" + //
                        "\n" + //
                        "Đa nhiệm thường làm giảm chất lượng và hiệu suất.\n" + //
                        "\n" + //
                        "Chương 6. Hoàn thành từng bước\n" + //
                        "\n" + //
                        "Nội dung\n" + //
                        "\n" + //
                        "Chia công việc lớn thành nhiều bước nhỏ.\n" + //
                        "Kiểm tra kết quả sau mỗi bước.\n" + //
                        "\n" + //
                        "Bài học\n" + //
                        "\n" + //
                        "Tiến bộ đều đặn hiệu quả hơn cố gắng làm tất cả trong một lần.\n" + //
                        "\n" + //
                        "Chương 7. Duy trì tiêu chuẩn\n" + //
                        "\n" + //
                        "Nội dung\n" + //
                        "\n" + //
                        "Thiết lập quy trình.\n" + //
                        "Làm đúng quy trình mỗi lần.\n" + //
                        "\n" + //
                        "Bài học\n" + //
                        "\n" + //
                        "Sự ổn định tạo ra chất lượng ổn định.\n" + //
                        "\n" + //
                        "Chương 8. Làm việc nhóm hiệu quả\n" + //
                        "\n" + //
                        "Nội dung\n" + //
                        "\n" + //
                        "Phân công rõ ràng.\n" + //
                        "Giao tiếp ngắn gọn.\n" + //
                        "Tin tưởng lẫn nhau.\n" + //
                        "\n" + //
                        "Bài học\n" + //
                        "\n" + //
                        "Hiệu quả của đội nhóm phụ thuộc vào sự phối hợp, không chỉ năng lực cá nhân.\n" + //
                        "\n" + //
                        "Chương 9. Chuẩn bị cho tình huống bất ngờ\n" + //
                        "\n" + //
                        "Nội dung\n" + //
                        "\n" + //
                        "Luôn có phương án dự phòng.\n" + //
                        "Dự đoán những rủi ro có thể xảy ra.\n" + //
                        "\n" + //
                        "Bài học\n" + //
                        "\n" + //
                        "Chuẩn bị trước giúp bình tĩnh khi gặp sự cố.\n" + //
                        "\n" + //
                        "Chương 10. Biến kỷ luật thành thói quen\n" + //
                        "\n" + //
                        "Nội dung\n" + //
                        "\n" + //
                        "Lặp lại các nguyên tắc mỗi ngày.\n" + //
                        "Duy trì sự ngăn nắp và chủ động.\n" + //
                        "\n" + //
                        "Bài học\n" + //
                        "\n" + //
                        "Hiệu suất lâu dài đến từ thói quen, không phải động lực nhất thời.");
        // #endregion
        b10.setCategory(c2);
        b10.setAuthors(new ArrayList<>(Arrays.asList(a10)));
        b10.setCoverImage("/images/10439-lam-ra-lam-choi-ra-choi-1.webp");
        bookRepository.save(b10);

        Book b11 = new Book();
        b11.setBookName("TÔI TỰ HỌC");
        b11.setPublisher("Trẻ");
        b11.setYearPublish(1999);
        b11.setQuantity(12);
        b11.setBorrowCount(1);
        // #region Book Detail
        b11.setBookDetail("Tôi Tự Học – Tóm tắt và các chương\n" + //
                        "\n" + //
                        "Tôi Tự Học là tác phẩm nổi tiếng của Nguyễn Duy Cần, xuất bản lần đầu vào năm 1961. Đây là một trong những cuốn sách kinh điển về phương pháp tự học, tự rèn luyện và phát triển bản thân của Việt Nam. Cuốn sách không chỉ hướng dẫn cách học mà còn bàn về thái độ học tập, tư duy và việc học suốt đời.\n" + //
                        "\n" + //
                        "Tóm tắt toàn bộ tác phẩm\n" + //
                        "\n" + //
                        "Thông điệp trung tâm của cuốn sách là:\n" + //
                        "\n" + //
                        "Học là một quá trình tự thân, không ai có thể học thay chúng ta.\n" + //
                        "\n" + //
                        "Theo Nguyễn Duy Cần, trường học và thầy cô chỉ là người hướng dẫn. Thành công trong học tập phụ thuộc chủ yếu vào:\n" + //
                        "\n" + //
                        "Tinh thần ham học.\n" + //
                        "Ý chí tự học.\n" + //
                        "Khả năng tư duy độc lập.\n" + //
                        "Thói quen đọc sách.\n" + //
                        "Việc vận dụng kiến thức vào thực tế.\n" + //
                        "\n" + //
                        "Tác giả khẳng định rằng tự học là con đường duy nhất giúp con người phát triển lâu dài, bởi kiến thức trong nhà trường chỉ là nền tảng ban đầu.\n" + //
                        "\n" + //
                        "Bố cục và tóm tắt các chương\n" + //
                        "\n" + //
                        "Các lần tái bản có thể chia chương hơi khác nhau, nhưng nội dung thường được trình bày theo 9 chương chính.\n" + //
                        "\n" + //
                        "Chương 1. Học là gì?\n" + //
                        "Nội dung\n" + //
                        "Khái niệm học.\n" + //
                        "Mục đích của việc học.\n" + //
                        "Học để hoàn thiện bản thân chứ không chỉ để thi cử.\n" + //
                        "Bài học\n" + //
                        "\n" + //
                        "Học không phải là ghi nhớ nhiều kiến thức mà là hiểu và biết vận dụng.\n" + //
                        "\n" + //
                        "Chương 2. Vì sao phải tự học?\n" + //
                        "Nội dung\n" + //
                        "Không ai có thể học thay người khác.\n" + //
                        "Trường học chỉ cung cấp nền tảng.\n" + //
                        "Thành công phụ thuộc vào việc tự học sau giờ học.\n" + //
                        "Bài học\n" + //
                        "\n" + //
                        "Người có khả năng tự học sẽ tiếp tục phát triển ngay cả khi không còn đi học.\n" + //
                        "\n" + //
                        "Chương 3. Điều kiện để tự học\n" + //
                        "Nội dung\n" + //
                        "\n" + //
                        "Tác giả nhấn mạnh các yếu tố:\n" + //
                        "\n" + //
                        "Lòng ham học.\n" + //
                        "Tính kiên trì.\n" + //
                        "Sự tập trung.\n" + //
                        "Tính kỷ luật.\n" + //
                        "Bài học\n" + //
                        "\n" + //
                        "Muốn học tốt phải rèn luyện ý chí trước khi rèn luyện trí tuệ.\n" + //
                        "\n" + //
                        "Chương 4. Phương pháp đọc sách\n" + //
                        "Nội dung\n" + //
                        "Chọn sách phù hợp.\n" + //
                        "Không đọc quá nhiều một lúc.\n" + //
                        "Đọc có suy nghĩ.\n" + //
                        "Ghi chép điều quan trọng.\n" + //
                        "Bài học\n" + //
                        "\n" + //
                        "Đọc ít nhưng hiểu sâu còn giá trị hơn đọc nhiều mà hời hợt.\n" + //
                        "\n" + //
                        "Chương 5. Phương pháp suy nghĩ\n" + //
                        "Nội dung\n" + //
                        "Không tiếp nhận kiến thức một cách thụ động.\n" + //
                        "Luôn đặt câu hỏi.\n" + //
                        "So sánh và phân tích.\n" + //
                        "Bài học\n" + //
                        "\n" + //
                        "Tư duy độc lập là mục tiêu cao nhất của việc học.\n" + //
                        "\n" + //
                        "Chương 6. Học đi đôi với hành\n" + //
                        "Nội dung\n" + //
                        "Kiến thức phải được áp dụng.\n" + //
                        "Trải nghiệm thực tế giúp hiểu sâu hơn.\n" + //
                        "Bài học\n" + //
                        "\n" + //
                        "Điều biết mà không làm thì chưa thật sự biết.\n" + //
                        "\n" + //
                        "Chương 7. Học suốt đời\n" + //
                        "Nội dung\n" + //
                        "Không có giới hạn tuổi tác trong việc học.\n" + //
                        "Người thành công luôn học hỏi.\n" + //
                        "Bài học\n" + //
                        "\n" + //
                        "Việc học kéo dài từ khi sinh ra đến hết cuộc đời.\n" + //
                        "\n" + //
                        "Chương 8. Rèn luyện nhân cách\n" + //
                        "Nội dung\n" + //
                        "Học để trở thành người tốt.\n" + //
                        "Đạo đức quan trọng không kém tri thức.\n" + //
                        "Bài học\n" + //
                        "\n" + //
                        "Tri thức nếu không đi cùng đạo đức có thể gây hại.\n" + //
                        "\n" + //
                        "Chương 9. Tinh thần tự lập\n" + //
                        "Nội dung\n" + //
                        "Chủ động tìm hiểu.\n" + //
                        "Không phụ thuộc hoàn toàn vào thầy cô.\n" + //
                        "Tự chịu trách nhiệm về việc học.\n" + //
                        "Bài học\n" + //
                        "\n" + //
                        "Người tự học là người làm chủ tương lai của mình.");
        // #endregion
        b11.setCategory(c2);
        b11.setAuthors(new ArrayList<>(Arrays.asList(a11)));
        b11.setCoverImage("/images/837-toi-tu-hoc-1.webp");
        bookRepository.save(b11);

        Book b12 = new Book();
        b12.setBookName("THIÊN TÀI BÊN TRÁI - KẺ ĐIÊN BÊN PHẢI");
        b12.setPublisher(" Thế Giới");
        b12.setYearPublish(1999);
        b12.setQuantity(12);
        b12.setBorrowCount(1);
        // #region Book Detail
        b12.setBookDetail("Thiên Tài Bên Trái, Kẻ Điên Bên Phải – Tóm tắt và các chương\n" + //
                        "\n" + //
                        "Thiên Tài Bên Trái, Kẻ Điên Bên Phải (左手天才，右手疯子) là tác phẩm của Cao Minh (高铭), xuất bản lần đầu tại Trung Quốc năm 2010. Cuốn sách là tập hợp các cuộc trò chuyện giữa tác giả với những người mắc các rối loạn tâm thần, được trình bày dưới dạng ghi chép và đối thoại. Qua đó, tác giả đặt ra nhiều câu hỏi về ranh giới giữa \"thiên tài\" và \"điên loạn\", cũng như về bản chất của thực tại và nhận thức.\n" + //
                        "\n" + //
                        "Lưu ý: Tác phẩm thuộc thể loại phi hư cấu pha yếu tố tự sự. Nhiều câu chuyện được kể dưới góc nhìn của tác giả và không nên xem là tài liệu khoa học về tâm thần học.\n" + //
                        "\n" + //
                        "Tóm tắt toàn bộ tác phẩm\n" + //
                        "\n" + //
                        "Khác với tiểu thuyết có cốt truyện xuyên suốt, cuốn sách gồm nhiều câu chuyện độc lập.\n" + //
                        "\n" + //
                        "Trong mỗi chương, tác giả gặp gỡ một người được chẩn đoán mắc bệnh tâm thần hoặc có cách nhìn thế giới rất khác thường. Qua các cuộc đối thoại, người đọc được tiếp cận những góc nhìn về:\n" + //
                        "\n" + //
                        "Thời gian và không gian.\n" + //
                        "Ý thức và linh hồn.\n" + //
                        "Thế giới song song.\n" + //
                        "Giấc mơ.\n" + //
                        "Cái chết.\n" + //
                        "Niềm tin và tôn giáo.\n" + //
                        "Bản ngã.\n" + //
                        "Thực tại và ảo giác.\n" + //
                        "\n" + //
                        "Điểm đặc biệt của cuốn sách là không cố gắng chứng minh ai đúng ai sai, mà khuyến khích người đọc suy ngẫm về cách con người nhận thức thế giới.\n" + //
                        "\n" + //
                        "Bố cục và tóm tắt các chương\n" + //
                        "\n" + //
                        "Tùy theo từng bản dịch và nhà xuất bản, số lượng chương có thể khác nhau (thường khoảng 40–50 chương), nhưng đều là các câu chuyện độc lập. Dưới đây là các nhóm nội dung chính.\n" + //
                        "\n" + //
                        "Phần 1. Những góc nhìn khác về thế giới\n" + //
                        "Nội dung\n" + //
                        "\n" + //
                        "Tác giả gặp những người tin rằng:\n" + //
                        "\n" + //
                        "Thế giới đang sống chỉ là một lớp thực tại.\n" + //
                        "Có nhiều chiều không gian tồn tại song song.\n" + //
                        "Con người có thể cảm nhận những điều người khác không thấy.\n" + //
                        "Chủ đề\n" + //
                        "Thực tại.\n" + //
                        "Nhận thức.\n" + //
                        "Thế giới song song.\n" + //
                        "Phần 2. Thời gian và ký ức\n" + //
                        "Nội dung\n" + //
                        "\n" + //
                        "Một số nhân vật cho rằng:\n" + //
                        "\n" + //
                        "Quá khứ và tương lai tồn tại đồng thời.\n" + //
                        "Ký ức có thể bị thay đổi.\n" + //
                        "Con người đang sống trong một vòng lặp thời gian.\n" + //
                        "Chủ đề\n" + //
                        "Bản chất của thời gian.\n" + //
                        "Trí nhớ.\n" + //
                        "Ý thức.\n" + //
                        "Phần 3. Giấc mơ và ý thức\n" + //
                        "Nội dung\n" + //
                        "\n" + //
                        "Các cuộc trò chuyện xoay quanh:\n" + //
                        "\n" + //
                        "Giấc mơ.\n" + //
                        "Ý thức khi ngủ.\n" + //
                        "Trải nghiệm cận tử.\n" + //
                        "Khả năng phân biệt giữa mơ và thực.\n" + //
                        "Chủ đề\n" + //
                        "Tiềm thức.\n" + //
                        "Nhận thức.\n" + //
                        "Giấc mơ.\n" + //
                        "Phần 4. Linh hồn và cái chết\n" + //
                        "Nội dung\n" + //
                        "\n" + //
                        "Nhiều nhân vật đưa ra quan điểm riêng về:\n" + //
                        "\n" + //
                        "Linh hồn.\n" + //
                        "Sự sống sau cái chết.\n" + //
                        "Luân hồi.\n" + //
                        "Ý nghĩa của sự tồn tại.\n" + //
                        "Chủ đề\n" + //
                        "Triết học.\n" + //
                        "Tôn giáo.\n" + //
                        "Siêu hình học.\n" + //
                        "Phần 5. Thiên tài và bệnh lý\n" + //
                        "Nội dung\n" + //
                        "\n" + //
                        "Tác giả đặt câu hỏi:\n" + //
                        "\n" + //
                        "Thiên tài và người mắc bệnh tâm thần khác nhau ở đâu?\n" + //
                        "Liệu những ý tưởng kỳ lạ có luôn là biểu hiện của bệnh lý?\n" + //
                        "Điều gì quyết định một người được xem là \"bình thường\"?\n" + //
                        "Chủ đề\n" + //
                        "Sáng tạo.\n" + //
                        "Tâm lý học.\n" + //
                        "Chuẩn mực xã hội.\n" + //
                        "Phần 6. Bản chất con người\n" + //
                        "Nội dung\n" + //
                        "\n" + //
                        "Những cuộc đối thoại hướng đến các vấn đề:\n" + //
                        "\n" + //
                        "Cái tôi.\n" + //
                        "Niềm tin.\n" + //
                        "Tự do ý chí.\n" + //
                        "Đạo đức.\n" + //
                        "Chủ đề\n" + //
                        "Triết học.\n" + //
                        "Tâm lý học.\n" + //
                        "Ý nghĩa cuộc sống");
        // #endregion
        b12.setCategory(c2);
        b12.setAuthors(new ArrayList<>(Arrays.asList(a12)));
        b12.setCoverImage("/images/1241-thien-tai-ben-trai-ke-dien-ben-phai-1.webp");
        bookRepository.save(b12);

        Book b13 = new Book();
        b13.setBookName("48 NGUYÊN TẮC CHỦ CHỐT CỦA QUYỀN LỰC");
        b13.setPublisher(" Trẻ");
        b13.setYearPublish(1999);
        b13.setQuantity(14);
        b13.setBorrowCount(1);
        // #region Book Detail 
        b13.setBookDetail("48 Nguyên Tắc Chủ Chốt Của Quyền Lực – Tóm tắt và các chương\n" + //
                        "\n" + //
                        "48 Nguyên Tắc Chủ Chốt Của Quyền Lực (The 48 Laws of Power) là tác phẩm của Robert Greene, xuất bản năm 1998. Cuốn sách tổng hợp các bài học về quyền lực từ lịch sử, chính trị, quân sự và kinh doanh, dựa trên các nhân vật như Niccolò Machiavelli, Tôn Tử, Carl von Clausewitz, Otto von Bismarck, Louis XIV và nhiều nhân vật khác.\n" + //
                        "\n" + //
                        "Lưu ý: Đây là một cuốn sách mang tính mô tả và phân tích các chiến lược quyền lực trong lịch sử, không phải là một cẩm nang đạo đức. Một số nguyên tắc có thể gây tranh cãi vì phản ánh cách quyền lực đã được sử dụng, chứ không nhất thiết là điều nên làm trong mọi hoàn cảnh.\n" + //
                        "\n" + //
                        "Tóm tắt toàn bộ tác phẩm\n" + //
                        "\n" + //
                        "Robert Greene cho rằng:\n" + //
                        "\n" + //
                        "Quyền lực luôn tồn tại trong mọi tổ chức và mối quan hệ.\n" + //
                        "Người không hiểu quy luật của quyền lực dễ bị người khác chi phối.\n" + //
                        "Hiểu các nguyên tắc này giúp nhận diện, tự bảo vệ và sử dụng ảnh hưởng một cách hiệu quả.\n" + //
                        "\n" + //
                        "Mỗi chương của sách trình bày:\n" + //
                        "\n" + //
                        "Một nguyên tắc.\n" + //
                        "Các ví dụ lịch sử minh họa.\n" + //
                        "Phân tích cách vận dụng.\n" + //
                        "Những trường hợp ngoại lệ hoặc rủi ro khi áp dụng.\n" + //
                        "Tóm tắt 48 chương (48 nguyên tắc)\n" + //
                        "Phần I. Xây dựng vị thế (Nguyên tắc 1–12)\n" + //
                        "1. Không bao giờ làm lu mờ cấp trên\n" + //
                        "\n" + //
                        "Đừng khiến người có quyền lực cảm thấy bị đe dọa; hãy để họ cảm thấy nổi bật.\n" + //
                        "\n" + //
                        "2. Đừng quá tin bạn bè, hãy học cách sử dụng đối thủ\n" + //
                        "\n" + //
                        "Đôi khi đối thủ cũ có động lực chứng minh bản thân hơn bạn bè thân thiết.\n" + //
                        "\n" + //
                        "3. Giấu kín ý định\n" + //
                        "\n" + //
                        "Không để người khác dễ dàng đoán được kế hoạch của bạn.\n" + //
                        "\n" + //
                        "4. Nói ít hơn mức cần thiết\n" + //
                        "\n" + //
                        "Sự tiết chế trong lời nói giúp tránh để lộ thông tin và tăng sức nặng cho phát biểu.\n" + //
                        "\n" + //
                        "5. Bảo vệ danh tiếng\n" + //
                        "\n" + //
                        "Uy tín là một dạng quyền lực; cần xây dựng và gìn giữ lâu dài.\n" + //
                        "\n" + //
                        "6. Thu hút sự chú ý\n" + //
                        "\n" + //
                        "Nếu không được chú ý, bạn khó tạo ảnh hưởng.\n" + //
                        "\n" + //
                        "7. Để người khác giúp, nhưng ghi nhận đúng công lao\n" + //
                        "\n" + //
                        "Biết phối hợp nguồn lực, đồng thời ứng xử công bằng với những người đóng góp.\n" + //
                        "\n" + //
                        "8. Khiến người khác chủ động tìm đến\n" + //
                        "\n" + //
                        "Tạo giá trị để người khác muốn hợp tác với bạn.\n" + //
                        "\n" + //
                        "9. Thuyết phục bằng kết quả\n" + //
                        "\n" + //
                        "Hành động và thành quả thường thuyết phục hơn tranh luận.\n" + //
                        "\n" + //
                        "10. Tránh những người luôn bi quan hoặc gây ảnh hưởng tiêu cực\n" + //
                        "\n" + //
                        "Thái độ và môi trường có thể ảnh hưởng mạnh đến hiệu suất của bạn.\n" + //
                        "\n" + //
                        "11. Khiến người khác coi trọng sự hiện diện của bạn\n" + //
                        "\n" + //
                        "Trở thành người có giá trị và khó thay thế.\n" + //
                        "\n" + //
                        "12. Chân thành đúng lúc\n" + //
                        "\n" + //
                        "Sự cởi mở và trung thực đúng mức có thể tạo dựng lòng tin.\n" + //
                        "\n" + //
                        "Phần II. Củng cố ảnh hưởng (Nguyên tắc 13–24)\n" + //
                        "13. Đánh vào lợi ích của người khác\n" + //
                        "\n" + //
                        "Khi hợp tác hoặc thuyết phục, hãy hiểu điều gì có ý nghĩa với đối phương.\n" + //
                        "\n" + //
                        "14. Quan sát nhiều hơn nói\n" + //
                        "\n" + //
                        "Thu thập thông tin giúp đưa ra quyết định tốt hơn.\n" + //
                        "\n" + //
                        "15. Loại bỏ tận gốc nguy cơ nếu buộc phải giải quyết xung đột\n" + //
                        "\n" + //
                        "Greene dùng nhiều ví dụ lịch sử về các cuộc đấu tranh quyền lực; trong bối cảnh hiện đại, bài học phù hợp hơn là giải quyết triệt để nguyên nhân của vấn đề thay vì để nó kéo dài.\n" + //
                        "\n" + //
                        "16. Biết tạo sự khan hiếm\n" + //
                        "\n" + //
                        "Giá trị thường tăng khi không phải lúc nào cũng sẵn có.\n" + //
                        "\n" + //
                        "17. Giữ sự khó đoán\n" + //
                        "\n" + //
                        "Một mức độ bất ngờ có thể giúp bạn tránh bị người khác dễ dàng dự liệu.\n" + //
                        "\n" + //
                        "18. Không tự cô lập\n" + //
                        "\n" + //
                        "Mạng lưới quan hệ là nguồn lực quan trọng.\n" + //
                        "\n" + //
                        "19. Hiểu rõ đối tượng trước khi hành động\n" + //
                        "\n" + //
                        "Tránh áp dụng một cách tiếp cận cho tất cả mọi người.\n" + //
                        "\n" + //
                        "20. Giữ quyền tự chủ\n" + //
                        "\n" + //
                        "Hạn chế phụ thuộc hoàn toàn vào một cá nhân hay tổ chức.\n" + //
                        "\n" + //
                        "21. Khiêm tốn đúng lúc\n" + //
                        "\n" + //
                        "Không nhất thiết phải chứng tỏ mình biết mọi thứ.\n" + //
                        "\n" + //
                        "22. Chuyển thế yếu thành lợi thế\n" + //
                        "\n" + //
                        "Linh hoạt thích nghi khi ở vị trí bất lợi.\n" + //
                        "\n" + //
                        "23. Tập trung nguồn lực\n" + //
                        "\n" + //
                        "Đầu tư vào những mục tiêu quan trọng thay vì dàn trải.\n" + //
                        "\n" + //
                        "24. Khéo léo trong ứng xử\n" + //
                        "\n" + //
                        "Sự tinh tế trong giao tiếp giúp xây dựng ảnh hưởng lâu dài.\n" + //
                        "\n" + //
                        "Phần III. Chiến lược hành động (Nguyên tắc 25–36)\n" + //
                        "25. Chủ động xây dựng hình ảnh cá nhân.\n" + //
                        "26. Giữ danh tiếng trong sạch.\n" + //
                        "27. Hiểu sức mạnh của niềm tin và cộng đồng.\n" + //
                        "28. Hành động dứt khoát khi đã quyết định.\n" + //
                        "29. Lập kế hoạch đến điểm kết thúc.\n" + //
                        "30. Thể hiện sự tự nhiên sau quá trình chuẩn bị kỹ.\n" + //
                        "31. Tạo lựa chọn thay vì chỉ đưa một phương án.\n" + //
                        "32. Hiểu và quản lý kỳ vọng của người khác.\n" + //
                        "33. Tìm ra động lực của từng người.\n" + //
                        "34. Thể hiện sự tự tin và phẩm giá.\n" + //
                        "35. Kiên nhẫn, biết chờ thời điểm thích hợp.\n" + //
                        "36. Không lãng phí năng lượng vào những điều không đáng.\n" + //
                        "Phần IV. Duy trì quyền lực (Nguyên tắc 37–48)\n" + //
                        "37. Sử dụng hình ảnh và biểu tượng để truyền tải thông điệp.\n" + //
                        "38. Linh hoạt thích nghi với môi trường.\n" + //
                        "39. Quản lý cảm xúc trong xung đột.\n" + //
                        "40. Đề cao giá trị của sự đầu tư và cam kết.\n" + //
                        "41. Tạo dấu ấn riêng thay vì chỉ đi theo người khác.\n" + //
                        "42. Giải quyết nguyên nhân cốt lõi của vấn đề.\n" + //
                        "43. Chinh phục bằng sự thấu hiểu.\n" + //
                        "44. Phản chiếu để hiểu đối phương và điều chỉnh cách ứng xử.\n" + //
                        "45. Thay đổi từng bước để tạo sự đồng thuận.\n" + //
                        "46. Tránh tự mãn sau thành công.\n" + //
                        "47. Biết dừng đúng lúc khi đã đạt mục tiêu.\n" + //
                        "48. Luôn linh hoạt và thích nghi với hoàn cảnh.");
        // #endregion
        b13.setCategory(c2);
        b13.setAuthors(new ArrayList<>(Arrays.asList(a13)));
        b13.setCoverImage("/images/1850-48-nguyen-tac-chu-chot-cua-quyen-luc-1.webp");
        bookRepository.save(b13);

        Book b14 = new Book();
        b14.setBookName("TRÍ TUỆ CỦA NGƯỜI XƯA");
        b14.setPublisher("  Văn Học");
        b14.setYearPublish(2022);
        b14.setQuantity(15);
        b14.setBorrowCount(1);
        // #region Book Detail
        b14.setBookDetail("Trí Tuệ Của Người Xưa – Tóm tắt và các chương\n" + //
                        "\n" + //
                        "Trí Tuệ Của Người Xưa là tên gọi được dùng cho nhiều đầu sách khác nhau tại Việt Nam. Không có một tác phẩm kinh điển duy nhất mang tên này. Phần lớn các ấn bản đều là sách tuyển chọn và bình giải những tư tưởng của các bậc hiền triết như Khổng Tử, Lão Tử, Trang Tử, Mạnh Tử, Tôn Tử, Hàn Phi Tử... Vì vậy, mục lục và số chương sẽ khác nhau tùy theo tác giả và nhà xuất bản.\n" + //
                        "\n" + //
                        "Dưới đây là bố cục và nội dung phổ biến của các ấn bản mang tên Trí Tuệ Của Người Xưa.\n" + //
                        "\n" + //
                        "Tóm tắt toàn bộ tác phẩm\n" + //
                        "\n" + //
                        "Cuốn sách tập hợp những bài học từ triết học và văn hóa phương Đông nhằm giúp người đọc:\n" + //
                        "\n" + //
                        "Tu dưỡng đạo đức.\n" + //
                        "Đối nhân xử thế.\n" + //
                        "Quản lý cảm xúc.\n" + //
                        "Lãnh đạo và dùng người.\n" + //
                        "Xây dựng sự nghiệp.\n" + //
                        "Sống hài hòa với tự nhiên.\n" + //
                        "Không ngừng học hỏi và hoàn thiện bản thân.\n" + //
                        "\n" + //
                        "Thông qua các câu chuyện lịch sử, điển tích và lời dạy của các bậc hiền triết, tác phẩm hướng người đọc đến một cuộc sống cân bằng giữa trí tuệ, đạo đức và hành động.\n" + //
                        "\n" + //
                        "Bố cục và tóm tắt các chương\n" + //
                        "\n" + //
                        "Nhiều phiên bản được chia thành khoảng 10 chương theo các chủ đề sau.\n" + //
                        "\n" + //
                        "Chương 1. Tu thân\n" + //
                        "Nội dung\n" + //
                        "Hiểu bản thân.\n" + //
                        "Sửa đổi khuyết điểm.\n" + //
                        "Rèn luyện phẩm chất.\n" + //
                        "Bài học\n" + //
                        "\n" + //
                        "Muốn thành công phải bắt đầu từ việc hoàn thiện chính mình.\n" + //
                        "\n" + //
                        "Chương 2. Đạo làm người\n" + //
                        "Nội dung\n" + //
                        "Nhân nghĩa.\n" + //
                        "Lễ.\n" + //
                        "Tín.\n" + //
                        "Trung thực.\n" + //
                        "Khiêm tốn.\n" + //
                        "Bài học\n" + //
                        "\n" + //
                        "Đạo đức là nền tảng của mọi mối quan hệ.\n" + //
                        "\n" + //
                        "Chương 3. Nghệ thuật đối nhân xử thế\n" + //
                        "Nội dung\n" + //
                        "Cách giao tiếp.\n" + //
                        "Biết lắng nghe.\n" + //
                        "Tôn trọng người khác.\n" + //
                        "Giữ chữ tín.\n" + //
                        "Bài học\n" + //
                        "\n" + //
                        "Ứng xử khéo léo giúp xây dựng các mối quan hệ bền vững.\n" + //
                        "\n" + //
                        "Chương 4. Trí tuệ lãnh đạo\n" + //
                        "Nội dung\n" + //
                        "Dùng người.\n" + //
                        "Tạo niềm tin.\n" + //
                        "Phân công hợp lý.\n" + //
                        "Quyết đoán.\n" + //
                        "Bài học\n" + //
                        "\n" + //
                        "Người lãnh đạo giỏi biết phát huy điểm mạnh của người khác.\n" + //
                        "\n" + //
                        "Chương 5. Thành công và thất bại\n" + //
                        "Nội dung\n" + //
                        "Nguyên nhân thành công.\n" + //
                        "Những sai lầm thường gặp.\n" + //
                        "Cách vượt qua nghịch cảnh.\n" + //
                        "Bài học\n" + //
                        "\n" + //
                        "Thất bại là cơ hội để học hỏi và trưởng thành.\n" + //
                        "\n" + //
                        "Chương 6. Nghệ thuật dùng người\n" + //
                        "Nội dung\n" + //
                        "Nhìn người.\n" + //
                        "Tin người đúng mức.\n" + //
                        "Trọng dụng người tài.\n" + //
                        "Tránh thiên vị.\n" + //
                        "Bài học\n" + //
                        "\n" + //
                        "Biết dùng người là yếu tố quan trọng của người lãnh đạo.\n" + //
                        "\n" + //
                        "Chương 7. Quản lý cảm xúc\n" + //
                        "Nội dung\n" + //
                        "Kiểm soát nóng giận.\n" + //
                        "Bình tĩnh trước khó khăn.\n" + //
                        "Không để cảm xúc chi phối quyết định.\n" + //
                        "Bài học\n" + //
                        "\n" + //
                        "Làm chủ bản thân là nền tảng của trí tuệ.\n" + //
                        "\n" + //
                        "Chương 8. Thuận theo tự nhiên\n" + //
                        "Nội dung\n" + //
                        "Tư tưởng của Lão Tử và Trang Tử.\n" + //
                        "Sống hài hòa với quy luật tự nhiên.\n" + //
                        "Không cưỡng cầu.\n" + //
                        "Bài học\n" + //
                        "\n" + //
                        "Linh hoạt và biết thích nghi giúp con người sống an nhiên hơn.\n" + //
                        "\n" + //
                        "Chương 9. Học tập suốt đời\n" + //
                        "Nội dung\n" + //
                        "Không ngừng học hỏi.\n" + //
                        "Học từ người khác.\n" + //
                        "Học từ thất bại.\n" + //
                        "Học từ thực tiễn.\n" + //
                        "Bài học\n" + //
                        "\n" + //
                        "Kiến thức chỉ có giá trị khi được tiếp tục trau dồi và áp dụng.\n" + //
                        "\n" + //
                        "Chương 10. Trí tuệ trong cuộc sống\n" + //
                        "Nội dung\n" + //
                        "Cân bằng giữa công việc và gia đình.\n" + //
                        "Quản lý thời gian.\n" + //
                        "Giữ tâm bình an.\n" + //
                        "Sống có mục đích.\n" + //
                        "Bài học\n" + //
                        "\n" + //
                        "Hạnh phúc không chỉ đến từ thành công mà còn từ cách sống đúng với giá trị của mình");
        // #endregion
        b14.setCategory(c2);
        b14.setAuthors(new ArrayList<>(Arrays.asList(a14)));
        b14.setCoverImage("/images/6059-tri-tue-cua-nguoi-xua-1.webp");
        bookRepository.save(b14);

        Book b15 = new Book();
        b15.setBookName("CÁI DŨNG CỦA THÁNH NHÂN");
        b15.setPublisher("Trẻ");
        b15.setYearPublish(2022);
        b15.setQuantity(16);
        b15.setBorrowCount(1);
        // #region Book Detail
        b15.setBookDetail("Cái Dũng Của Thánh Nhân – Tóm tắt và các chương\n" + //
                        "\n" + //
                        "Cái Dũng Của Thánh Nhân là tác phẩm của Nguyễn Duy Cần, một học giả nổi tiếng với các sách về triết học phương Đông và nghệ thuật sống như Tôi Tự Học, Óc Sáng Suốt, Thuật Xử Thế Của Người Xưa. Cuốn sách phân tích khái niệm \"dũng\" (lòng can đảm) theo tư tưởng của Nho giáo, Đạo giáo và Phật giáo, nhấn mạnh rằng lòng dũng cảm cao nhất là chiến thắng chính mình, chứ không phải chỉ là sự gan dạ trên chiến trường.\n" + //
                        "\n" + //
                        "Tóm tắt toàn bộ tác phẩm\n" + //
                        "\n" + //
                        "Thông điệp trung tâm của cuốn sách là:\n" + //
                        "\n" + //
                        "Người mạnh nhất không phải người thắng người khác, mà là người thắng được chính mình.\n" + //
                        "\n" + //
                        "Theo Nguyễn Duy Cần:\n" + //
                        "\n" + //
                        "Cái dũng chân chính bắt nguồn từ trí tuệ và đạo đức.\n" + //
                        "Người quân tử không hiếu chiến nhưng không hèn nhát.\n" + //
                        "Người có bản lĩnh biết giữ bình tĩnh trước lợi danh, cám dỗ và nghịch cảnh.\n" + //
                        "Can đảm không đồng nghĩa với liều lĩnh; dũng cần đi cùng nhân và trí.\n" + //
                        "\n" + //
                        "Tác giả sử dụng nhiều điển tích và lời dạy của Khổng Tử, Mạnh Tử, Lão Tử và các nhân vật lịch sử để minh họa cho quan điểm này.\n" + //
                        "\n" + //
                        "Bố cục và tóm tắt các chương\n" + //
                        "\n" + //
                        "Các lần tái bản có thể khác nhau về cách chia chương. Nội dung thường được trình bày theo các chủ đề sau.\n" + //
                        "\n" + //
                        "Chương 1. Thế nào là cái dũng?\n" + //
                        "Nội dung\n" + //
                        "Khái niệm \"dũng\" trong triết học phương Đông.\n" + //
                        "Phân biệt dũng với sự bốc đồng và liều lĩnh.\n" + //
                        "Bài học\n" + //
                        "\n" + //
                        "Can đảm thật sự là hành động đúng dù gặp khó khăn hay nguy hiểm.\n" + //
                        "\n" + //
                        "Chương 2. Dũng của kẻ thất phu và dũng của thánh nhân\n" + //
                        "Nội dung\n" + //
                        "\n" + //
                        "Tác giả so sánh:\n" + //
                        "\n" + //
                        "Kẻ thất phu: dễ nổi nóng, thích chứng tỏ sức mạnh.\n" + //
                        "Thánh nhân: điềm tĩnh, biết tự chủ và hành động vì điều đúng.\n" + //
                        "Bài học\n" + //
                        "\n" + //
                        "Sức mạnh của sự tự chủ thường lớn hơn sức mạnh của vũ lực.\n" + //
                        "\n" + //
                        "Chương 3. Chiến thắng bản thân\n" + //
                        "Nội dung\n" + //
                        "Kiểm soát lòng tham.\n" + //
                        "Kiềm chế nóng giận.\n" + //
                        "Vượt qua sợ hãi.\n" + //
                        "Bài học\n" + //
                        "\n" + //
                        "Chiến thắng bản thân là thử thách khó khăn nhất nhưng cũng là nền tảng của mọi thành tựu.\n" + //
                        "\n" + //
                        "Chương 4. Dũng và trí\n" + //
                        "Nội dung\n" + //
                        "Dũng cần đi cùng trí tuệ.\n" + //
                        "Hành động phải có suy xét.\n" + //
                        "Bài học\n" + //
                        "\n" + //
                        "Can đảm mà thiếu trí tuệ dễ dẫn đến hậu quả không mong muốn.\n" + //
                        "\n" + //
                        "Chương 5. Dũng và nhân\n" + //
                        "Nội dung\n" + //
                        "Lòng dũng cảm phải hướng đến điều thiện.\n" + //
                        "Bảo vệ lẽ phải và người yếu thế.\n" + //
                        "Bài học\n" + //
                        "\n" + //
                        "Dũng không chỉ vì bản thân mà còn vì trách nhiệm với người khác.\n" + //
                        "\n" + //
                        "Chương 6. Dũng trước nghịch cảnh\n" + //
                        "Nội dung\n" + //
                        "Đối diện thất bại.\n" + //
                        "Kiên trì trước khó khăn.\n" + //
                        "Không nản lòng.\n" + //
                        "Bài học\n" + //
                        "\n" + //
                        "Nghị lực được thể hiện qua cách con người đứng dậy sau thất bại.\n" + //
                        "\n" + //
                        "Chương 7. Dũng trong lời nói và hành động\n" + //
                        "Nội dung\n" + //
                        "Dám nói sự thật.\n" + //
                        "Dám nhận sai.\n" + //
                        "Dám chịu trách nhiệm.\n" + //
                        "Bài học\n" + //
                        "\n" + //
                        "Thừa nhận sai lầm và sửa đổi cũng là biểu hiện của lòng dũng cảm.\n" + //
                        "\n" + //
                        "Chương 8. Tu dưỡng để có cái dũng của thánh nhân\n" + //
                        "Nội dung\n" + //
                        "Rèn luyện đạo đức.\n" + //
                        "Học hỏi không ngừng.\n" + //
                        "Giữ tâm bình an.\n" + //
                        "Sống đúng với lương tâm.\n" + //
                        "Bài học\n" + //
                        "\n" + //
                        "Lòng dũng cảm không phải phẩm chất bẩm sinh mà được hình thành qua quá trình tu dưỡng.");
        // #endregion
        b15.setCategory(c2);
        b15.setAuthors(new ArrayList<>(Arrays.asList(a15)));
        b15.setCoverImage("/images/590-cai-dung-cua-thanh-nhan-1.webp");
        bookRepository.save(b15);

        //Category c3
        Book b16 = new Book();
        b16.setBookName("KHOA HỌC TÂM LINH - HÀNH TRÌNH TÌM LẠI CHÍNH MÌNH");
        b16.setPublisher("Trẻ");
        b16.setYearPublish(2026);
        b16.setQuantity(5);
        b16.setBorrowCount(1);
        // #region Book Detail 
        b16.setBookDetail("Khoa Học Tâm Linh – Hành Trình Tìm Lại Chính Mình – Tóm tắt và các chương\n" + //
                        "\n" + //
                        "Khoa Học Tâm Linh – Hành Trình Tìm Lại Chính Mình là một đầu sách về phát triển bản thân và tâm linh được phát hành tại Việt Nam. Nội dung kết hợp các chủ đề như nhận thức bản thân, thiền định, năng lượng, chữa lành và ý nghĩa cuộc sống. Đây không phải là một công trình khoa học thực nghiệm, mà là tác phẩm thuộc thể loại tâm linh – tự lực (self-help), trong đó có nhiều quan điểm mang tính triết lý hoặc niềm tin cá nhân.\n" + //
                        "\n" + //
                        "Lưu ý: Các nội dung liên quan đến \"năng lượng\", \"luật hấp dẫn\", \"rung động\", \"luân xa\" hoặc những khái niệm tương tự trong sách không phải đều đã được khoa học hiện đại xác nhận. Người đọc nên phân biệt giữa trải nghiệm cá nhân, triết lý sống và bằng chứng khoa học.\n" + //
                        "\n" + //
                        "Tóm tắt toàn bộ tác phẩm\n" + //
                        "\n" + //
                        "Cuốn sách hướng người đọc đến hành trình khám phá nội tâm với thông điệp:\n" + //
                        "\n" + //
                        "Muốn thay đổi cuộc sống, trước hết hãy thay đổi chính mình.\n" + //
                        "\n" + //
                        "Tác giả cho rằng nhiều vấn đề trong cuộc sống bắt nguồn từ:\n" + //
                        "\n" + //
                        "Thiếu hiểu biết về bản thân.\n" + //
                        "Những niềm tin giới hạn.\n" + //
                        "Căng thẳng và cảm xúc tiêu cực.\n" + //
                        "Mất cân bằng giữa thể chất, tinh thần và cảm xúc.\n" + //
                        "\n" + //
                        "Thông qua việc quan sát bản thân, rèn luyện tâm trí và thay đổi cách nhìn nhận cuộc sống, con người có thể sống bình an và có mục đích hơn.\n" + //
                        "\n" + //
                        "Bố cục và tóm tắt các chương\n" + //
                        "\n" + //
                        "Tùy theo từng lần xuất bản, tên chương có thể khác nhau. Nội dung thường được trình bày theo các chủ đề sau.\n" + //
                        "\n" + //
                        "Chương 1. Bạn là ai?\n" + //
                        "Nội dung\n" + //
                        "Tự nhận thức.\n" + //
                        "Hiểu bản thân.\n" + //
                        "Xác định giá trị sống.\n" + //
                        "Bài học\n" + //
                        "\n" + //
                        "Hiểu chính mình là bước đầu tiên để thay đổi.\n" + //
                        "\n" + //
                        "Chương 2. Sức mạnh của tâm trí\n" + //
                        "Nội dung\n" + //
                        "Vai trò của suy nghĩ.\n" + //
                        "Ảnh hưởng của niềm tin.\n" + //
                        "Thói quen tư duy.\n" + //
                        "Bài học\n" + //
                        "\n" + //
                        "Cách chúng ta diễn giải sự việc có ảnh hưởng lớn đến cảm xúc và hành động.\n" + //
                        "\n" + //
                        "Chương 3. Cảm xúc và sự chữa lành\n" + //
                        "Nội dung\n" + //
                        "Nhận diện cảm xúc.\n" + //
                        "Buông bỏ oán giận.\n" + //
                        "Tha thứ.\n" + //
                        "Bài học\n" + //
                        "\n" + //
                        "Đối diện và xử lý cảm xúc là một phần quan trọng của sự trưởng thành.\n" + //
                        "\n" + //
                        "Chương 4. Thiền và chánh niệm\n" + //
                        "Nội dung\n" + //
                        "Quan sát hơi thở.\n" + //
                        "Sống trong hiện tại.\n" + //
                        "Giảm căng thẳng.\n" + //
                        "Bài học\n" + //
                        "\n" + //
                        "Thiền và chánh niệm có thể giúp cải thiện khả năng tập trung và điều hòa cảm xúc; nhiều nghiên cứu cũng ghi nhận lợi ích này trong một số bối cảnh.\n" + //
                        "\n" + //
                        "Chương 5. Niềm tin và sự thay đổi\n" + //
                        "Nội dung\n" + //
                        "Nhận diện niềm tin giới hạn.\n" + //
                        "Xây dựng tư duy tích cực.\n" + //
                        "Hình thành thói quen mới.\n" + //
                        "Bài học\n" + //
                        "\n" + //
                        "Thay đổi thường bắt đầu từ việc xem xét lại những giả định của chính mình.\n" + //
                        "\n" + //
                        "Chương 6. Năng lượng và sự cân bằng\n" + //
                        "Nội dung\n" + //
                        "\n" + //
                        "Sách đề cập đến:\n" + //
                        "\n" + //
                        "Năng lượng cá nhân.\n" + //
                        "Sự cân bằng thân – tâm.\n" + //
                        "Môi trường sống.\n" + //
                        "Bài học\n" + //
                        "\n" + //
                        "Việc nghỉ ngơi hợp lý, vận động, chăm sóc sức khỏe và duy trì các mối quan hệ tích cực góp phần tạo nên cảm giác cân bằng. Các diễn giải về \"năng lượng\" trong sách chủ yếu thuộc góc nhìn tâm linh.\n" + //
                        "\n" + //
                        "Chương 7. Mối quan hệ\n" + //
                        "Nội dung\n" + //
                        "Yêu thương.\n" + //
                        "Đồng cảm.\n" + //
                        "Biết lắng nghe.\n" + //
                        "Chấp nhận sự khác biệt.\n" + //
                        "Bài học\n" + //
                        "\n" + //
                        "Chất lượng các mối quan hệ phụ thuộc nhiều vào cách chúng ta giao tiếp và thấu hiểu người khác.\n" + //
                        "\n" + //
                        "Chương 8. Sống đúng với giá trị của mình\n" + //
                        "Nội dung\n" + //
                        "Mục tiêu sống.\n" + //
                        "Trách nhiệm cá nhân.\n" + //
                        "Ý nghĩa cuộc đời.\n" + //
                        "Bài học\n" + //
                        "\n" + //
                        "Một cuộc sống có ý nghĩa thường gắn với những giá trị mà mỗi người tự lựa chọn và theo đuổi.");
        // #endregion
        b16.setCategory(c3);
        b16.setAuthors(new ArrayList<>(Arrays.asList(a16)));
        b16.setCoverImage("/images/5504-khoa-hoc-tam-linh-hanh-trinh-tim-lai-chinh-minh-1.jpg");
        bookRepository.save(b16);

        Book b17 = new Book();
        b17.setBookName("GIÁO TRÌNH NHỮNG NGUYÊN LÍ CƠ BẢN CỦA CHỦ NGHĨA MAC-LENIN");
        b17.setPublisher("Bộ Giáo Dục Và Đào Tạo");
        b17.setYearPublish(2014);
        b17.setQuantity(5);
        b17.setBorrowCount(1);
        // #region Book Detail
        b17.setBookDetail("Giáo trình Những Nguyên Lý Cơ Bản của Chủ Nghĩa Mác – Lênin – Tóm tắt và các chương\n" + //
                        "\n" + //
                        "Giáo trình Những Nguyên lý cơ bản của Chủ nghĩa Mác – Lênin là giáo trình được sử dụng trong các trường đại học, cao đẳng ở Việt Nam nhằm giới thiệu những nội dung nền tảng của học thuyết Karl Marx, Friedrich Engels và Vladimir Ilyich Lenin. Giáo trình trình bày ba bộ phận cấu thành của chủ nghĩa Mác – Lênin:\n" + //
                        "\n" + //
                        "Triết học Mác – Lênin\n" + //
                        "Kinh tế chính trị Mác – Lênin\n" + //
                        "Chủ nghĩa xã hội khoa học\n" + //
                        "\n" + //
                        "Lưu ý: Đây là giáo trình trình bày học thuyết Mác – Lênin theo chương trình đào tạo của Việt Nam. Trong nghiên cứu học thuật, các nội dung của học thuyết này cũng được phân tích, tranh luận và đánh giá từ nhiều góc nhìn khác nhau.\n" + //
                        "\n" + //
                        "Tóm tắt toàn bộ giáo trình\n" + //
                        "\n" + //
                        "Giáo trình nhằm giúp người học:\n" + //
                        "\n" + //
                        "Hiểu thế giới quan và phương pháp luận của chủ nghĩa Mác – Lênin.\n" + //
                        "Nắm các quy luật vận động của tự nhiên, xã hội và tư duy theo lý luận Mác – Lênin.\n" + //
                        "Hiểu các khái niệm về sản xuất, kinh tế, giai cấp và nhà nước trong hệ thống lý luận này.\n" + //
                        "Tìm hiểu quan điểm của chủ nghĩa Mác – Lênin về chủ nghĩa xã hội và quá trình phát triển xã hội.\n" + //
                        "\n" + //
                        "Thông thường, giáo trình gồm 9 chương, chia thành ba phần lớn.\n" + //
                        "\n" + //
                        "PHẦN I. TRIẾT HỌC MÁC – LÊNIN\n" + //
                        "Chương 1. Chủ nghĩa duy vật biện chứng và chủ nghĩa duy vật lịch sử\n" + //
                        "Nội dung\n" + //
                        "Sự ra đời của triết học Mác.\n" + //
                        "Vật chất và ý thức.\n" + //
                        "Phép biện chứng duy vật.\n" + //
                        "Chủ nghĩa duy vật lịch sử.\n" + //
                        "Kiến thức trọng tâm\n" + //
                        "Vật chất có trước, ý thức có sau theo quan điểm duy vật.\n" + //
                        "Thế giới luôn vận động và phát triển.\n" + //
                        "Sự phát triển diễn ra thông qua các mâu thuẫn và sự biến đổi.\n" + //
                        "Chương 2. Phép biện chứng duy vật\n" + //
                        "Nội dung\n" + //
                        "Hai nguyên lý cơ bản.\n" + //
                        "Ba quy luật.\n" + //
                        "Các cặp phạm trù.\n" + //
                        "Hai nguyên lý\n" + //
                        "Mối liên hệ phổ biến.\n" + //
                        "Sự phát triển.\n" + //
                        "Ba quy luật\n" + //
                        "Quy luật thống nhất và đấu tranh của các mặt đối lập.\n" + //
                        "Quy luật chuyển hóa từ lượng thành chất và ngược lại.\n" + //
                        "Quy luật phủ định của phủ định.\n" + //
                        "Chương 3. Nhận thức\n" + //
                        "Nội dung\n" + //
                        "Bản chất của nhận thức.\n" + //
                        "Thực tiễn.\n" + //
                        "Chân lý.\n" + //
                        "Kiến thức trọng tâm\n" + //
                        "\n" + //
                        "Theo giáo trình, thực tiễn được xem là cơ sở, động lực và tiêu chuẩn để kiểm nghiệm chân lý.\n" + //
                        "\n" + //
                        "PHẦN II. KINH TẾ CHÍNH TRỊ MÁC – LÊNIN\n" + //
                        "Chương 4. Hàng hóa và sản xuất hàng hóa\n" + //
                        "Nội dung\n" + //
                        "Hàng hóa.\n" + //
                        "Giá trị.\n" + //
                        "Giá trị sử dụng.\n" + //
                        "Tiền tệ.\n" + //
                        "Kiến thức trọng tâm\n" + //
                        "\n" + //
                        "Giải thích các khái niệm nền tảng trong lý luận kinh tế của Mác về sản xuất và trao đổi hàng hóa.\n" + //
                        "\n" + //
                        "Chương 5. Giá trị thặng dư\n" + //
                        "Nội dung\n" + //
                        "Sức lao động.\n" + //
                        "Quá trình sản xuất.\n" + //
                        "Giá trị thặng dư.\n" + //
                        "Kiến thức trọng tâm\n" + //
                        "\n" + //
                        "Đây là một trong những khái niệm trung tâm của kinh tế chính trị Mác, dùng để phân tích quan hệ giữa lao động và lợi nhuận trong nền sản xuất tư bản chủ nghĩa theo quan điểm của Mác.\n" + //
                        "\n" + //
                        "Chương 6. Chủ nghĩa tư bản độc quyền và xu hướng phát triển\n" + //
                        "Nội dung\n" + //
                        "Tích tụ tư bản.\n" + //
                        "Tập trung tư bản.\n" + //
                        "Độc quyền.\n" + //
                        "Toàn cầu hóa.\n" + //
                        "Kiến thức trọng tâm\n" + //
                        "\n" + //
                        "Trình bày quan điểm của chủ nghĩa Mác – Lênin về sự phát triển của chủ nghĩa tư bản và những biến đổi của nó.\n" + //
                        "\n" + //
                        "PHẦN III. CHỦ NGHĨA XÃ HỘI KHOA HỌC\n" + //
                        "Chương 7. Sứ mệnh lịch sử của giai cấp công nhân\n" + //
                        "Nội dung\n" + //
                        "Giai cấp công nhân.\n" + //
                        "Đảng Cộng sản.\n" + //
                        "Cách mạng xã hội.\n" + //
                        "Kiến thức trọng tâm\n" + //
                        "\n" + //
                        "Giáo trình trình bày quan điểm của chủ nghĩa Mác – Lênin về vai trò của giai cấp công nhân trong tiến trình phát triển xã hội.\n" + //
                        "\n" + //
                        "Chương 8. Chủ nghĩa xã hội và thời kỳ quá độ\n" + //
                        "Nội dung\n" + //
                        "Khái niệm chủ nghĩa xã hội.\n" + //
                        "Đặc trưng của xã hội xã hội chủ nghĩa.\n" + //
                        "Thời kỳ quá độ.\n" + //
                        "Kiến thức trọng tâm\n" + //
                        "\n" + //
                        "Phân tích những đặc điểm và mục tiêu của chủ nghĩa xã hội theo hệ thống lý luận Mác – Lênin.\n" + //
                        "\n" + //
                        "Chương 9. Những vấn đề chính trị – xã hội\n" + //
                        "Nội dung\n" + //
                        "Nhà nước.\n" + //
                        "Dân chủ.\n" + //
                        "Văn hóa.\n" + //
                        "Con người.\n" + //
                        "Dân tộc.\n" + //
                        "Tôn giáo.\n" + //
                        "Kiến thức trọng tâm\n" + //
                        "\n" + //
                        "Giáo trình trình bày quan điểm của chủ nghĩa Mác – Lênin về các vấn đề xã hội và vai trò của chúng trong quá trình phát triển.");
        // #endregion
        b17.setCategory(c3);
        b17.setAuthors(new ArrayList<>(Arrays.asList(a17)));
        b17.setCoverImage("/images/5930-giao-trinh-nhung-nguyen-li-co-ban-cua-chu-nghia-mac-lenin-1.webp");
        bookRepository.save(b17);

        Book b18 = new Book();
        b18.setBookName("GIÁ NHƯ TÔI BIẾT ĐƯỢC NHỮNG ĐIỀU NÀY TRƯỚC KHI THI TOEIC");
        b18.setPublisher("Thanh Niên");
        b18.setYearPublish(2015);
        b18.setQuantity(5);
        b18.setBorrowCount(1);
        // #region Book Detail   
        b18.setBookDetail("Giá Như Tôi Biết Được Những Điều Này Trước Khi Thi TOEIC – Tóm tắt và các chương\n" + //
                        "\n" + //
                        "Giá Như Tôi Biết Được Những Điều Này Trước Khi Thi TOEIC là một cuốn sách hướng dẫn ôn luyện kỳ thi TOEIC (Test of English for International Communication), tập trung vào chiến lược học tập, kỹ năng làm bài và những lỗi thường gặp. Mục tiêu của sách là giúp người học tiết kiệm thời gian ôn luyện, tránh những sai lầm phổ biến và cải thiện điểm số thông qua phương pháp học có hệ thống.\n" + //
                        "\n" + //
                        "Tóm tắt toàn bộ tác phẩm\n" + //
                        "\n" + //
                        "Thông điệp chính của cuốn sách là:\n" + //
                        "\n" + //
                        "Điểm TOEIC cao không chỉ đến từ vốn tiếng Anh, mà còn từ phương pháp học và chiến lược làm bài phù hợp.\n" + //
                        "\n" + //
                        "Tác giả chia sẻ kinh nghiệm thực tế về:\n" + //
                        "\n" + //
                        "Cách xây dựng lộ trình học.\n" + //
                        "Phương pháp cải thiện từ vựng và ngữ pháp.\n" + //
                        "Kỹ năng luyện nghe và đọc.\n" + //
                        "Chiến thuật xử lý từng dạng câu hỏi.\n" + //
                        "Những điều cần chuẩn bị trước và trong ngày thi.\n" + //
                        "Bố cục và tóm tắt các chương\n" + //
                        "\n" + //
                        "Tùy theo từng lần tái bản, cách chia chương có thể khác nhau. Nội dung thường được tổ chức theo các chủ đề dưới đây.\n" + //
                        "\n" + //
                        "Chương 1. Hiểu về kỳ thi TOEIC\n" + //
                        "Nội dung\n" + //
                        "Cấu trúc bài thi.\n" + //
                        "Thang điểm.\n" + //
                        "Các phần Listening và Reading.\n" + //
                        "Tiêu chí đánh giá.\n" + //
                        "Bài học\n" + //
                        "\n" + //
                        "Nắm rõ cấu trúc đề thi giúp lập kế hoạch ôn tập hiệu quả.\n" + //
                        "\n" + //
                        "Chương 2. Những sai lầm phổ biến khi ôn TOEIC\n" + //
                        "Nội dung\n" + //
                        "Học quá nhiều tài liệu cùng lúc.\n" + //
                        "Chỉ học mẹo mà bỏ qua nền tảng.\n" + //
                        "Không luyện đề theo thời gian thực.\n" + //
                        "Bài học\n" + //
                        "\n" + //
                        "Học đúng phương pháp quan trọng hơn học quá nhiều.\n" + //
                        "\n" + //
                        "Chương 3. Xây dựng nền tảng từ vựng\n" + //
                        "Nội dung\n" + //
                        "Học từ theo chủ đề.\n" + //
                        "Ghi nhớ cụm từ (collocations).\n" + //
                        "Ôn tập bằng lặp lại ngắt quãng (spaced repetition).\n" + //
                        "Bài học\n" + //
                        "\n" + //
                        "Từ vựng cần được học trong ngữ cảnh thay vì học từng từ riêng lẻ.\n" + //
                        "\n" + //
                        "Chương 4. Ngữ pháp trọng tâm\n" + //
                        "Nội dung\n" + //
                        "Thì động từ.\n" + //
                        "Từ loại.\n" + //
                        "Mệnh đề.\n" + //
                        "Câu bị động.\n" + //
                        "Liên từ và giới từ.\n" + //
                        "Bài học\n" + //
                        "\n" + //
                        "Nắm chắc các điểm ngữ pháp thường xuất hiện sẽ giúp làm nhanh và chính xác hơn.\n" + //
                        "\n" + //
                        "Chương 5. Kỹ năng Listening\n" + //
                        "Nội dung\n" + //
                        "Nghe ý chính.\n" + //
                        "Nhận diện từ khóa.\n" + //
                        "Làm quen với nhiều giọng đọc.\n" + //
                        "Tránh bẫy trong câu hỏi.\n" + //
                        "Bài học\n" + //
                        "\n" + //
                        "Không cần hiểu từng từ; hãy tập trung vào thông tin quan trọng.\n" + //
                        "\n" + //
                        "Chương 6. Kỹ năng Reading\n" + //
                        "Nội dung\n" + //
                        "Đọc lướt (skimming).\n" + //
                        "Tìm thông tin (scanning).\n" + //
                        "Quản lý thời gian.\n" + //
                        "Phân tích văn bản.\n" + //
                        "Bài học\n" + //
                        "\n" + //
                        "Đọc có chiến lược giúp tiết kiệm thời gian và tăng độ chính xác.\n" + //
                        "\n" + //
                        "Chương 7. Chiến thuật làm bài\n" + //
                        "Nội dung\n" + //
                        "Phân bổ thời gian.\n" + //
                        "Làm câu dễ trước.\n" + //
                        "Xử lý câu khó.\n" + //
                        "Kiểm soát tâm lý trong phòng thi.\n" + //
                        "Bài học\n" + //
                        "\n" + //
                        "Chiến lược hợp lý có thể giúp tối ưu hóa điểm số.\n" + //
                        "\n" + //
                        "Chương 8. Lộ trình ôn tập\n" + //
                        "Nội dung\n" + //
                        "Kế hoạch học theo mục tiêu điểm.\n" + //
                        "Luyện đề định kỳ.\n" + //
                        "Đánh giá tiến bộ.\n" + //
                        "Bài học\n" + //
                        "\n" + //
                        "Việc ôn luyện đều đặn và có kế hoạch hiệu quả hơn học dồn trước kỳ thi.");
        // #endregion
        b18.setCategory(c3);
        b18.setAuthors(new ArrayList<>(Arrays.asList(a18)));
        b18.setCoverImage("/images/6089-gia-nhu-toi-biet-duoc-nhung-dieu-nay-truoc-khi-thi-toeic-1.webp");
        bookRepository.save(b18);

        Book b19 = new Book();
        b19.setBookName("TÂM LÝ HỌC ĐẠI CƯƠNG");
        b19.setPublisher("Khoa Học Xã Hội");
        b19.setYearPublish(1997);
        b19.setQuantity(5);
        b19.setBorrowCount(1);
        // #region Book Detail   
        b19.setBookDetail("Tâm Lý Học Đại Cương – Tóm tắt và các chương\n" + //
                        "\n" + //
                        "Tâm Lý Học Đại Cương là giáo trình nhập môn về tâm lý học, được sử dụng rộng rãi tại nhiều trường đại học. Ở Việt Nam, có nhiều phiên bản của các tác giả như Nguyễn Quang Uẩn, Phạm Minh Hạc, hoặc các giáo trình dịch từ nước ngoài. Dù cách chia chương có khác nhau, nội dung cốt lõi đều giới thiệu những khái niệm và lĩnh vực nền tảng của tâm lý học.\n" + //
                        "\n" + //
                        "Tóm tắt toàn bộ giáo trình\n" + //
                        "\n" + //
                        "Mục tiêu của Tâm Lý Học Đại Cương là giúp người học:\n" + //
                        "\n" + //
                        "Hiểu tâm lý học là gì và nghiên cứu điều gì.\n" + //
                        "Nắm được các quy luật hình thành và phát triển tâm lý con người.\n" + //
                        "Tìm hiểu các quá trình nhận thức, cảm xúc, động cơ, nhân cách và hành vi.\n" + //
                        "Biết cách vận dụng kiến thức tâm lý học trong học tập, công việc và cuộc sống.\n" + //
                        "\n" + //
                        "Giáo trình thường được chia thành 10–12 chương, từ các khái niệm cơ bản đến những nội dung chuyên sâu hơn.\n" + //
                        "\n" + //
                        "Chương 1. Đối tượng, nhiệm vụ và phương pháp nghiên cứu của tâm lý học\n" + //
                        "Nội dung\n" + //
                        "Khái niệm tâm lý học.\n" + //
                        "Đối tượng nghiên cứu.\n" + //
                        "Vai trò của tâm lý học.\n" + //
                        "Các phương pháp nghiên cứu.\n" + //
                        "Kiến thức trọng tâm\n" + //
                        "\n" + //
                        "Tâm lý học nghiên cứu hành vi và các quá trình tâm thần (như nhận thức, cảm xúc, động cơ) của con người và, trong một số lĩnh vực, của động vật.\n" + //
                        "\n" + //
                        "Chương 2. Cơ sở sinh lý của tâm lý\n" + //
                        "Nội dung\n" + //
                        "Não bộ.\n" + //
                        "Hệ thần kinh.\n" + //
                        "Phản xạ.\n" + //
                        "Mối quan hệ giữa não và tâm lý.\n" + //
                        "Kiến thức trọng tâm\n" + //
                        "\n" + //
                        "Các hoạt động tâm lý có nền tảng từ hoạt động của hệ thần kinh, đặc biệt là não bộ.\n" + //
                        "\n" + //
                        "Chương 3. Sự hình thành và phát triển tâm lý\n" + //
                        "Nội dung\n" + //
                        "Nguồn gốc của tâm lý.\n" + //
                        "Vai trò của di truyền.\n" + //
                        "Vai trò của môi trường.\n" + //
                        "Hoạt động và giao tiếp.\n" + //
                        "Kiến thức trọng tâm\n" + //
                        "\n" + //
                        "Tâm lý được hình thành thông qua sự tương tác giữa yếu tố sinh học, môi trường và trải nghiệm cá nhân.\n" + //
                        "\n" + //
                        "Chương 4. Hoạt động nhận thức – Cảm giác và tri giác\n" + //
                        "Nội dung\n" + //
                        "Cảm giác.\n" + //
                        "Tri giác.\n" + //
                        "Quy luật tri giác.\n" + //
                        "Kiến thức trọng tâm\n" + //
                        "\n" + //
                        "Cảm giác và tri giác là những bước đầu tiên giúp con người tiếp nhận thông tin từ thế giới xung quanh.\n" + //
                        "\n" + //
                        "Chương 5. Trí nhớ\n" + //
                        "Nội dung\n" + //
                        "Ghi nhớ.\n" + //
                        "Lưu giữ.\n" + //
                        "Nhận lại.\n" + //
                        "Quên.\n" + //
                        "Kiến thức trọng tâm\n" + //
                        "\n" + //
                        "Trí nhớ giúp lưu trữ và sử dụng thông tin trong học tập và cuộc sống.\n" + //
                        "\n" + //
                        "Chương 6. Tư duy và tưởng tượng\n" + //
                        "Nội dung\n" + //
                        "Khái niệm tư duy.\n" + //
                        "Các thao tác tư duy.\n" + //
                        "Giải quyết vấn đề.\n" + //
                        "Tưởng tượng.\n" + //
                        "Kiến thức trọng tâm\n" + //
                        "\n" + //
                        "Tư duy giúp con người phân tích, suy luận và sáng tạo để giải quyết các tình huống mới.\n" + //
                        "\n" + //
                        "Chương 7. Chú ý và ngôn ngữ\n" + //
                        "Nội dung\n" + //
                        "Chú ý có chủ định và không chủ định.\n" + //
                        "Vai trò của ngôn ngữ trong tư duy và giao tiếp.\n" + //
                        "Kiến thức trọng tâm\n" + //
                        "\n" + //
                        "Chú ý giúp chọn lọc thông tin, còn ngôn ngữ là công cụ quan trọng để tư duy và truyền đạt.\n" + //
                        "\n" + //
                        "Chương 8. Tình cảm và cảm xúc\n" + //
                        "Nội dung\n" + //
                        "Cảm xúc.\n" + //
                        "Tình cảm.\n" + //
                        "Các trạng thái cảm xúc.\n" + //
                        "Kiến thức trọng tâm\n" + //
                        "\n" + //
                        "Cảm xúc ảnh hưởng đến hành vi, quyết định và các mối quan hệ của con người.\n" + //
                        "\n" + //
                        "Chương 9. Ý chí\n" + //
                        "Nội dung\n" + //
                        "Khái niệm ý chí.\n" + //
                        "Hành động có ý chí.\n" + //
                        "Phẩm chất ý chí.\n" + //
                        "Kiến thức trọng tâm\n" + //
                        "\n" + //
                        "Ý chí giúp con người vượt qua khó khăn và kiên trì theo đuổi mục tiêu.\n" + //
                        "\n" + //
                        "Chương 10. Nhân cách\n" + //
                        "Nội dung\n" + //
                        "Khái niệm nhân cách.\n" + //
                        "Cấu trúc nhân cách.\n" + //
                        "Các yếu tố ảnh hưởng đến sự hình thành nhân cách.\n" + //
                        "Kiến thức trọng tâm\n" + //
                        "\n" + //
                        "Nhân cách là hệ thống tương đối ổn định về đặc điểm tâm lý, được hình thành qua quá trình phát triển và trải nghiệm.\n" + //
                        "\n" + //
                        "Chương 11. Khí chất và năng lực (có trong nhiều giáo trình)\n" + //
                        "Nội dung\n" + //
                        "Các kiểu khí chất.\n" + //
                        "Khái niệm năng lực.\n" + //
                        "Tài năng.\n" + //
                        "Kiến thức trọng tâm\n" + //
                        "\n" + //
                        "Khí chất phản ánh phong cách phản ứng đặc trưng, còn năng lực liên quan đến khả năng thực hiện hiệu quả một hoạt động.\n" + //
                        "\n" + //
                        "Chương 12. Ứng dụng của tâm lý học (có trong nhiều giáo trình)\n" + //
                        "Nội dung\n" + //
                        "Tâm lý học giáo dục.\n" + //
                        "Tâm lý học lao động.\n" + //
                        "Tâm lý học quản lý.\n" + //
                        "Tâm lý học lâm sàng.\n" + //
                        "Kiến thức trọng tâm\n" + //
                        "\n" + //
                        "Kiến thức tâm lý học có thể được vận dụng trong nhiều lĩnh vực của đời sống.");
        // #endregion
        b19.setCategory(c3);
        b19.setAuthors(new ArrayList<>(Arrays.asList(a19)));
        b19.setCoverImage("/images/5955-tam-ly-hoc-dai-cuong-1.webp");
        bookRepository.save(b19);

        Book b20 = new Book();
        b20.setBookName("ĐỆ TỬ QUY");
        b20.setPublisher("Dân Trí");
        b20.setYearPublish(2021);
        b20.setQuantity(4);
        b20.setBorrowCount(1);
        // #region Book Detail   
        b20.setBookDetail("Đệ Tử Quy – Tóm tắt và các chương\n" + //
                        "\n" + //
                        "Đệ Tử Quy (弟子規) là một tác phẩm giáo huấn của Nho giáo, do Lý Dục Tú (李毓秀) biên soạn vào đầu thời nhà Thanh (thế kỷ XVII). Tác phẩm được viết dựa trên tư tưởng của Khổng Tử, đặc biệt là lời dạy trong Luận Ngữ:\n" + //
                        "\n" + //
                        "\"Đệ tử nhập tắc hiếu, xuất tắc đễ, cẩn nhi tín, phiếm ái chúng, nhi thân nhân, hành hữu dư lực, tắc dĩ học văn.\"\n" + //
                        "\n" + //
                        "Nghĩa là:\n" + //
                        "\n" + //
                        "\"Người làm con ở nhà phải hiếu thảo; ra ngoài phải kính nhường; cẩn thận và giữ chữ tín; yêu thương mọi người; gần gũi người nhân đức; nếu còn thời gian và sức lực thì học văn.\"\n" + //
                        "\n" + //
                        "Đệ Tử Quy được xem là sách nhập môn về đạo đức trong truyền thống Nho giáo, đặc biệt dành cho trẻ em và người mới học.\n" + //
                        "\n" + //
                        "Tóm tắt toàn bộ tác phẩm\n" + //
                        "\n" + //
                        "Đệ Tử Quy không phải là sách kể chuyện mà là tập hợp các quy tắc ứng xử trong gia đình và xã hội.\n" + //
                        "\n" + //
                        "Nội dung hướng dẫn con người:\n" + //
                        "\n" + //
                        "Hiếu kính cha mẹ.\n" + //
                        "Kính trọng anh chị và người lớn tuổi.\n" + //
                        "Giữ chữ tín.\n" + //
                        "Cẩn trọng trong lời nói và hành động.\n" + //
                        "Yêu thương mọi người.\n" + //
                        "Gần gũi người có đức.\n" + //
                        "Chăm chỉ học tập và rèn luyện.\n" + //
                        "\n" + //
                        "Tác phẩm gồm 1.080 chữ Hán, chia thành 7 phần lớn.\n" + //
                        "\n" + //
                        "Bố cục và tóm tắt các phần\n" + //
                        "1. Tổng cương (總敘)\n" + //
                        "Nội dung\n" + //
                        "\n" + //
                        "Giới thiệu toàn bộ tinh thần của sách.\n" + //
                        "\n" + //
                        "Tóm tắt sáu nguyên tắc:\n" + //
                        "\n" + //
                        "Hiếu.\n" + //
                        "Đễ.\n" + //
                        "Cẩn.\n" + //
                        "Tín.\n" + //
                        "Ái chúng.\n" + //
                        "Thân nhân.\n" + //
                        "Học văn.\n" + //
                        "Bài học\n" + //
                        "\n" + //
                        "Đạo đức là nền tảng trước khi học tri thức.\n" + //
                        "\n" + //
                        "2. Nhập tắc hiếu (入則孝)\n" + //
                        "Nội dung\n" + //
                        "\n" + //
                        "Dạy cách làm con:\n" + //
                        "\n" + //
                        "Hiếu kính cha mẹ.\n" + //
                        "Vâng lời.\n" + //
                        "Chăm sóc cha mẹ khi đau ốm.\n" + //
                        "Giữ gìn thanh danh gia đình.\n" + //
                        "Không làm cha mẹ lo lắng.\n" + //
                        "Bài học\n" + //
                        "\n" + //
                        "Hiếu là gốc của mọi đức hạnh.\n" + //
                        "\n" + //
                        "3. Xuất tắc đễ (出則弟)\n" + //
                        "Nội dung\n" + //
                        "\n" + //
                        "Dạy cách cư xử:\n" + //
                        "\n" + //
                        "Kính trọng anh chị.\n" + //
                        "Tôn trọng người lớn.\n" + //
                        "Hòa thuận với anh em.\n" + //
                        "Nhường nhịn.\n" + //
                        "Bài học\n" + //
                        "\n" + //
                        "Biết tôn trọng người khác là nền tảng của các mối quan hệ xã hội.\n" + //
                        "\n" + //
                        "4. Cẩn (謹)\n" + //
                        "Nội dung\n" + //
                        "\n" + //
                        "Rèn luyện bản thân:\n" + //
                        "\n" + //
                        "Ăn mặc gọn gàng.\n" + //
                        "Đúng giờ.\n" + //
                        "Giữ vệ sinh.\n" + //
                        "Làm việc cẩn thận.\n" + //
                        "Không lười biếng.\n" + //
                        "Bài học\n" + //
                        "\n" + //
                        "Người có kỷ luật sẽ được người khác tin tưởng.\n" + //
                        "\n" + //
                        "5. Tín (信)\n" + //
                        "Nội dung\n" + //
                        "\n" + //
                        "Giữ chữ tín:\n" + //
                        "\n" + //
                        "Không nói dối.\n" + //
                        "Giữ lời hứa.\n" + //
                        "Không khoe khoang.\n" + //
                        "Nói lời chân thật.\n" + //
                        "Bài học\n" + //
                        "\n" + //
                        "Uy tín được xây dựng từ sự trung thực và nhất quán.\n" + //
                        "\n" + //
                        "6. Phiếm ái chúng (汎愛眾)\n" + //
                        "Nội dung\n" + //
                        "\n" + //
                        "Yêu thương mọi người:\n" + //
                        "\n" + //
                        "Không phân biệt giàu nghèo.\n" + //
                        "Giúp đỡ người khác.\n" + //
                        "Không ích kỷ.\n" + //
                        "Bao dung.\n" + //
                        "Bài học\n" + //
                        "\n" + //
                        "Lòng nhân ái giúp xây dựng cộng đồng hòa thuận.\n" + //
                        "\n" + //
                        "7. Thân nhân – Hành hữu dư lực tắc dĩ học văn (親仁・餘力學文)\n" + //
                        "Nội dung\n" + //
                        "Thân nhân\n" + //
                        "Kết giao với người có đạo đức.\n" + //
                        "Học hỏi điều tốt.\n" + //
                        "Tránh bạn xấu.\n" + //
                        "Hành hữu dư lực tắc dĩ học văn\n" + //
                        "Sau khi rèn đạo đức mới học tri thức.\n" + //
                        "Đọc sách.\n" + //
                        "Học tập suốt đời.\n" + //
                        "Bài học\n" + //
                        "\n" + //
                        "Đạo đức và tri thức cần đi cùng nhau.");
        // #endregion
        b20.setCategory(c3);
        b20.setAuthors(new ArrayList<>(Arrays.asList(a20)));
        b20.setCoverImage("/images/6654-de-tu-quy-1.webp");
        bookRepository.save(b20);

        Book b21 = new Book();
        b21.setBookName("LÒNG THÀNH DÂNG THẦY");
        b21.setPublisher("Tổng Hợp Tp. Hcm");
        b21.setYearPublish(2011);
        b21.setQuantity(4);
        b21.setBorrowCount(45);
        // #region Book Detail   
        b21.setBookDetail("Lòng Thành Dâng Thầy – Tóm tắt và các chương\n" + //
                        "\n" + //
                        "Lòng Thành Dâng Thầy là một tên sách thường gặp trong các tuyển tập giáo dục đạo đức – tri ân thầy cô ở Việt Nam. Không có một bản kinh điển duy nhất, nhưng đa số ấn bản đều mang nội dung xoay quanh chủ đề tôn sư trọng đạo, kế thừa truyền thống “một chữ cũng là thầy, nửa chữ cũng là thầy”.\n" + //
                        "\n" + //
                        "Vì vậy, cấu trúc chương có thể khác nhau giữa các nhà xuất bản, nhưng nội dung cốt lõi khá thống nhất.\n" + //
                        "\n" + //
                        "Tóm tắt toàn bộ tác phẩm\n" + //
                        "\n" + //
                        "Cuốn sách nhấn mạnh:\n" + //
                        "\n" + //
                        "Công ơn thầy cô là nền tảng của tri thức và nhân cách.\n" + //
                        "\n" + //
                        "Thông qua các câu chuyện, gương sáng và bài học đạo đức, sách hướng người đọc đến:\n" + //
                        "\n" + //
                        "Biết ơn thầy cô giáo.\n" + //
                        "Hiểu vai trò của giáo dục trong cuộc đời.\n" + //
                        "Rèn luyện thái độ học tập đúng đắn.\n" + //
                        "Giữ gìn đạo lý “tôn sư trọng đạo”.\n" + //
                        "Sống có trách nhiệm với tri thức mình nhận được.\n" + //
                        "Bố cục và tóm tắt các chương (dạng phổ biến)\n" + //
                        "Chương 1. Ý nghĩa của nghề dạy học\n" + //
                        "Nội dung\n" + //
                        "Giáo dục là nền tảng phát triển xã hội.\n" + //
                        "Thầy cô là người khai sáng tri thức.\n" + //
                        "Nghề giáo gắn với sự hy sinh thầm lặng.\n" + //
                        "Bài học\n" + //
                        "\n" + //
                        "Tôn trọng người dạy chính là tôn trọng con đường học vấn của mình.\n" + //
                        "\n" + //
                        "Chương 2. Công ơn thầy cô\n" + //
                        "Nội dung\n" + //
                        "Dạy chữ, dạy người.\n" + //
                        "Sự kiên nhẫn và tận tụy của thầy cô.\n" + //
                        "Những đóng góp thầm lặng trong quá trình trưởng thành của học sinh.\n" + //
                        "Bài học\n" + //
                        "\n" + //
                        "Thành công của mỗi người luôn có dấu ấn của người thầy.\n" + //
                        "\n" + //
                        "Chương 3. Những tấm gương thầy cô tiêu biểu\n" + //
                        "Nội dung\n" + //
                        "Các câu chuyện về giáo viên tận tâm.\n" + //
                        "Những người thầy vượt khó để dạy học.\n" + //
                        "Tấm gương hy sinh vì học trò.\n" + //
                        "Bài học\n" + //
                        "\n" + //
                        "Sự cống hiến của thầy cô là động lực truyền cảm hứng học tập.\n" + //
                        "\n" + //
                        "Chương 4. Lòng biết ơn của học trò\n" + //
                        "Nội dung\n" + //
                        "Cách thể hiện sự biết ơn.\n" + //
                        "Tôn trọng, lễ phép với thầy cô.\n" + //
                        "Hành động cụ thể thay vì lời nói.\n" + //
                        "Bài học\n" + //
                        "\n" + //
                        "Biết ơn không chỉ là cảm xúc mà phải được thể hiện bằng hành động.\n" + //
                        "\n" + //
                        "Chương 5. Đạo lý “tôn sư trọng đạo”\n" + //
                        "Nội dung\n" + //
                        "Truyền thống văn hóa Việt Nam.\n" + //
                        "Vai trò của thầy trong xã hội xưa và nay.\n" + //
                        "Mối quan hệ thầy – trò.\n" + //
                        "Bài học\n" + //
                        "\n" + //
                        "Tôn sư trọng đạo là giá trị cốt lõi trong giáo dục và đạo đức con người.\n" + //
                        "\n" + //
                        "Chương 6. Trách nhiệm của học trò\n" + //
                        "Nội dung\n" + //
                        "Học tập chăm chỉ.\n" + //
                        "Không phụ công dạy dỗ.\n" + //
                        "Rèn luyện đạo đức và nhân cách.\n" + //
                        "Bài học\n" + //
                        "\n" + //
                        "Học trò giỏi không chỉ giỏi kiến thức mà còn phải biết sống đúng đạo lý.\n" + //
                        "\n" + //
                        "Chương 7. Thầy cô trong xã hội hiện đại\n" + //
                        "Nội dung\n" + //
                        "Vai trò giáo dục trong thời đại mới.\n" + //
                        "Thách thức của nghề giáo.\n" + //
                        "Sự thay đổi phương pháp dạy học.\n" + //
                        "Bài học\n" + //
                        "\n" + //
                        "Dù xã hội thay đổi, vai trò của người thầy vẫn không thể thay thế.\n" + //
                        "\n" + //
                        "Chương 8. Lan tỏa lòng biết ơn\n" + //
                        "Nội dung\n" + //
                        "Giữ gìn truyền thống tri ân.\n" + //
                        "Ngày Nhà giáo Việt Nam.\n" + //
                        "Truyền cảm hứng cho thế hệ sau.\n" + //
                        "Bài học\n" + //
                        "\n" + //
                        "Biết ơn thầy cô là giá trị cần được duy trì và lan tỏa.");
        // #endregion
        b21.setCategory(c3);
        b21.setAuthors(new ArrayList<>(Arrays.asList(a21)));
        b21.setCoverImage("/images/6261-long-thanh-dang-thay-1.webp");
        bookRepository.save(b21);

        Book b22 = new Book();
        b22.setBookName("NIỀM VUI MÙA AN CƯ");
        b22.setPublisher("Tổng Hợp Tp. Hcm");
        b22.setYearPublish(2011);
        b22.setQuantity(4);
        b22.setBorrowCount(1);
        // #region Book Detail   
        b22.setBookDetail("Niềm Vui Mùa An Cư – Tóm tắt và các chương\n" + //
                        "\n" + //
                        "Niềm Vui Mùa An Cư là một đầu sách mang màu sắc Phật học – đời sống tu tập, thường được biên soạn từ các bài giảng, câu chuyện hoặc ghi chép về mùa an cư kiết hạ của Tăng đoàn Phật giáo. Tùy từng ấn bản, nội dung có thể khác nhau, nhưng đều xoay quanh tinh thần tu học, chánh niệm và đời sống nội tâm thanh tịnh.\n" + //
                        "\n" + //
                        "Tóm tắt toàn bộ tác phẩm\n" + //
                        "\n" + //
                        "Thông điệp chính của cuốn sách là:\n" + //
                        "\n" + //
                        "Niềm vui chân thật không đến từ bên ngoài, mà từ sự an trú trong tâm và sự tu tập tỉnh thức.\n" + //
                        "\n" + //
                        "Trong mùa an cư kiết hạ, chư Tăng tập trung:\n" + //
                        "\n" + //
                        "Tu học giới – định – tuệ.\n" + //
                        "Hạn chế di chuyển để chuyên tâm thiền định.\n" + //
                        "Tăng cường học pháp và thực hành chánh niệm.\n" + //
                        "Nuôi dưỡng đời sống tinh thần thanh tịnh.\n" + //
                        "\n" + //
                        "Cuốn sách thường mô tả:\n" + //
                        "\n" + //
                        "Không khí tu học trong mùa an cư.\n" + //
                        "Những bài học về chánh niệm trong đời sống hằng ngày.\n" + //
                        "Cách chuyển hóa khổ đau, phiền não.\n" + //
                        "Niềm vui đến từ sự giản dị và tỉnh thức.\n" + //
                        "Bố cục và tóm tắt các chương (dạng phổ biến)\n" + //
                        "Chương 1. Ý nghĩa mùa an cư\n" + //
                        "Nội dung\n" + //
                        "Khái niệm an cư kiết hạ trong Phật giáo.\n" + //
                        "Mục đích: tu tập chuyên sâu, giữ giới nghiêm.\n" + //
                        "Vai trò của Tăng đoàn trong mùa an cư.\n" + //
                        "Bài học\n" + //
                        "\n" + //
                        "Dừng lại để tu tập giúp con người nhìn rõ chính mình hơn.\n" + //
                        "\n" + //
                        "Chương 2. Đời sống chánh niệm\n" + //
                        "Nội dung\n" + //
                        "Thực hành tỉnh thức trong từng hành động.\n" + //
                        "Ăn, ngủ, đi, đứng đều trong chánh niệm.\n" + //
                        "Quan sát tâm ý.\n" + //
                        "Bài học\n" + //
                        "\n" + //
                        "Chánh niệm giúp giảm khổ đau và tăng sự bình an.\n" + //
                        "\n" + //
                        "Chương 3. Học pháp trong mùa an cư\n" + //
                        "Nội dung\n" + //
                        "Nghe giảng pháp.\n" + //
                        "Học kinh điển.\n" + //
                        "Thảo luận giáo lý.\n" + //
                        "Bài học\n" + //
                        "\n" + //
                        "Tri thức tâm linh cần đi đôi với thực hành.\n" + //
                        "\n" + //
                        "Chương 4. Chuyển hóa thân tâm\n" + //
                        "Nội dung\n" + //
                        "Nhận diện tham, sân, si.\n" + //
                        "Quán chiếu bản thân.\n" + //
                        "Buông bỏ phiền não.\n" + //
                        "Bài học\n" + //
                        "\n" + //
                        "Chuyển hóa nội tâm là cốt lõi của tu tập.\n" + //
                        "\n" + //
                        "Chương 5. Niềm vui từ sự giản dị\n" + //
                        "Nội dung\n" + //
                        "Đời sống đơn sơ trong chùa.\n" + //
                        "Không phụ thuộc vật chất.\n" + //
                        "Hạnh phúc từ sự an tĩnh.\n" + //
                        "Bài học\n" + //
                        "\n" + //
                        "Hạnh phúc không đến từ sở hữu mà từ buông bỏ.\n" + //
                        "\n" + //
                        "Chương 6. Tăng thân và hòa hợp\n" + //
                        "Nội dung\n" + //
                        "Sống chung trong Tăng đoàn.\n" + //
                        "Hỗ trợ và nhẫn nhịn nhau.\n" + //
                        "Giữ hòa hợp trong cộng đồng tu học.\n" + //
                        "Bài học\n" + //
                        "\n" + //
                        "Hòa hợp là nền tảng của sự tu tập bền vững.\n" + //
                        "\n" + //
                        "Chương 7. Quán chiếu vô thường\n" + //
                        "Nội dung\n" + //
                        "Mọi sự vật đều thay đổi.\n" + //
                        "Không bám chấp vào hiện tượng.\n" + //
                        "Nhận thức về sinh – diệt.\n" + //
                        "Bài học\n" + //
                        "\n" + //
                        "Hiểu vô thường giúp giảm khổ đau và lo âu.\n" + //
                        "\n" + //
                        "Chương 8. Trở về với chính mình\n" + //
                        "Nội dung\n" + //
                        "Quan sát hơi thở.\n" + //
                        "Lắng nghe nội tâm.\n" + //
                        "Buông bỏ vọng tưởng.\n" + //
                        "Bài học\n" + //
                        "\n" + //
                        "Bình an chỉ có khi quay về chính mình.");
        // #endregion
        b22.setCategory(c3);
        b22.setAuthors(new ArrayList<>(Arrays.asList(a21)));
        b22.setCoverImage("/images/6525-niem-vui-mua-an-cu-1.webp");
        bookRepository.save(b22);

        Book b23 = new Book();
        b23.setBookName("8 ĐIỀU GIÁC NGỘ");
        b23.setPublisher("Tổng Hợp Tp. Hcm");
        b23.setYearPublish(2011);
        b23.setQuantity(4);
        b23.setBorrowCount(2);
        // #region Book Detail   
        b23.setBookDetail("8 Điều Giác Ngộ – Tóm tắt và các chương\n" + //
                        "\n" + //
                        "“8 Điều Giác Ngộ” thường là cách gọi phổ biến của các bản chú giải về “Bát Đại Nhân Giác Kinh” (八大人覺經) trong Phật giáo. Đây là một bản kinh ngắn, được xem là lời dạy về 8 sự quán chiếu quan trọng giúp người tu hành giác ngộ và sống tỉnh thức.\n" + //
                        "\n" + //
                        "Tùy bản dịch và sách diễn giải, cách chia chương có thể khác nhau, nhưng nội dung cốt lõi luôn xoay quanh 8 điều giác ngộ này.\n" + //
                        "\n" + //
                        "Tóm tắt toàn bộ tác phẩm\n" + //
                        "\n" + //
                        "Thông điệp chính của 8 Điều Giác Ngộ là:\n" + //
                        "\n" + //
                        "Con người khổ đau vì vô minh và chấp trước; muốn an lạc cần quán chiếu, buông bỏ và sống tỉnh thức.\n" + //
                        "\n" + //
                        "Tám điều giác ngộ hướng con người:\n" + //
                        "\n" + //
                        "Nhận ra sự vô thường của đời sống.\n" + //
                        "Giảm tham dục và ham muốn.\n" + //
                        "Biết đủ và sống đơn giản.\n" + //
                        "Chăm tu giới – định – tuệ.\n" + //
                        "Tránh lười biếng và buông lung.\n" + //
                        "Nuôi dưỡng trí tuệ và từ bi.\n" + //
                        "8 điều giác ngộ (nội dung chính)\n" + //
                        "1. Thế gian vô thường (無常)\n" + //
                        "Nội dung\n" + //
                        "Mọi sự vật đều thay đổi.\n" + //
                        "Không có gì tồn tại mãi mãi.\n" + //
                        "Bài học\n" + //
                        "\n" + //
                        "Hiểu vô thường giúp giảm bám chấp và khổ đau.\n" + //
                        "\n" + //
                        "2. Nhiều khổ đau (多苦)\n" + //
                        "Nội dung\n" + //
                        "Cuộc sống luôn có sinh, già, bệnh, chết.\n" + //
                        "Khổ đau là một phần tất yếu.\n" + //
                        "Bài học\n" + //
                        "\n" + //
                        "Nhận diện khổ đau để không trốn tránh mà chuyển hóa.\n" + //
                        "\n" + //
                        "3. Tâm là nguồn gốc khổ đau\n" + //
                        "Nội dung\n" + //
                        "Tham, sân, si tạo ra khổ.\n" + //
                        "Tâm bất an thì cuộc sống bất an.\n" + //
                        "Bài học\n" + //
                        "\n" + //
                        "Muốn thay đổi đời sống phải thay đổi nội tâm.\n" + //
                        "\n" + //
                        "4. Bốn sự thật về vô ngã\n" + //
                        "Nội dung\n" + //
                        "Không có “cái tôi” cố định.\n" + //
                        "Mọi thứ do duyên hợp mà thành.\n" + //
                        "Bài học\n" + //
                        "\n" + //
                        "Buông bỏ cái tôi giúp giảm xung đột và chấp trước.\n" + //
                        "\n" + //
                        "5. Giảm dục vọng\n" + //
                        "Nội dung\n" + //
                        "Ham muốn càng nhiều càng khổ.\n" + //
                        "Dục vọng không bao giờ có điểm dừng.\n" + //
                        "Bài học\n" + //
                        "\n" + //
                        "Biết đủ là nền tảng của hạnh phúc.\n" + //
                        "\n" + //
                        "6. Tinh tấn tu tập\n" + //
                        "Nội dung\n" + //
                        "Không buông lung.\n" + //
                        "Siêng năng thực hành giới – định – tuệ.\n" + //
                        "Bài học\n" + //
                        "\n" + //
                        "Chuyển hóa bản thân cần sự kiên trì.\n" + //
                        "\n" + //
                        "7. Phát triển trí tuệ\n" + //
                        "Nội dung\n" + //
                        "Trí tuệ giúp thấy rõ bản chất sự vật.\n" + //
                        "Phá vô minh.\n" + //
                        "Bài học\n" + //
                        "\n" + //
                        "Hiểu đúng giúp hành động đúng.\n" + //
                        "\n" + //
                        "8. Nuôi dưỡng từ bi\n" + //
                        "Nội dung\n" + //
                        "Yêu thương và giúp đỡ mọi người.\n" + //
                        "Không gây hại cho chúng sinh.\n" + //
                        "Bài học\n" + //
                        "\n" + //
                        "Từ bi là nền tảng của một đời sống an lạc.");
        // #endregion
        b23.setCategory(c3);
        b23.setAuthors(new ArrayList<>(Arrays.asList(a21)));
        b23.setCoverImage("/images/6749-8-dieu-giac-ngo-1.webp");
        bookRepository.save(b23);

        Book b24 = new Book();
        b24.setBookName("XUÂN TRONG TÔI");
        b24.setPublisher("Tổng Hợp Tp. Hcm");
        b24.setYearPublish(2003);
        b24.setQuantity(4);
        b24.setBorrowCount(1);
        // #region Book Detail   
        b24.setBookDetail("Xuân Trong Tôi – Tóm tắt và các chương\n" + //
                        "\n" + //
                        "“Xuân Trong Tôi” là một nhan đề khá phổ biến trong các tuyển tập văn học – tản văn – giáo dục cảm xúc ở Việt Nam. Tùy theo từng tác giả và nhà xuất bản, nội dung có thể khác nhau, nhưng nhìn chung đây là tập tản văn/nhật ký cảm xúc về mùa xuân, tuổi trẻ, ký ức và sự thức tỉnh nội tâm.\n" + //
                        "\n" + //
                        "Vì không phải một tiểu thuyết hay giáo trình có cấu trúc cố định, nên “các chương” thường là cách chia theo chủ đề hoặc bài viết.\n" + //
                        "\n" + //
                        "Tóm tắt toàn bộ tác phẩm\n" + //
                        "\n" + //
                        "Xuân Trong Tôi thường mang thông điệp:\n" + //
                        "\n" + //
                        "Mùa xuân không chỉ ở bên ngoài mà còn là trạng thái tâm hồn khi con người biết yêu thương, hy vọng và sống tích cực.\n" + //
                        "\n" + //
                        "Cuốn sách/tập tản văn thường khai thác:\n" + //
                        "\n" + //
                        "Ký ức tuổi thơ và những mùa xuân đã qua.\n" + //
                        "Cảm xúc về gia đình, quê hương, Tết cổ truyền.\n" + //
                        "Sự đổi thay của thời gian.\n" + //
                        "Niềm tin, hy vọng và sự khởi đầu mới.\n" + //
                        "Hành trình trưởng thành của con người.\n" + //
                        "Bố cục và các chương (dạng chủ đề phổ biến)\n" + //
                        "1. Xuân của ký ức\n" + //
                        "Nội dung\n" + //
                        "Hồi ức tuổi thơ.\n" + //
                        "Hình ảnh Tết xưa.\n" + //
                        "Gia đình quây quần.\n" + //
                        "Bài học\n" + //
                        "\n" + //
                        "Ký ức là nơi lưu giữ những giá trị tinh thần đẹp nhất.\n" + //
                        "\n" + //
                        "2. Xuân của quê hương\n" + //
                        "Nội dung\n" + //
                        "Cảnh sắc làng quê mùa xuân.\n" + //
                        "Chợ Tết, hoa đào, hoa mai.\n" + //
                        "Không khí sum vầy.\n" + //
                        "Bài học\n" + //
                        "\n" + //
                        "Quê hương là gốc rễ của cảm xúc và bản sắc.\n" + //
                        "\n" + //
                        "3. Xuân của gia đình\n" + //
                        "Nội dung\n" + //
                        "Tình cha mẹ, anh em.\n" + //
                        "Sự sum họp ngày Tết.\n" + //
                        "Sự gắn kết yêu thương.\n" + //
                        "Bài học\n" + //
                        "\n" + //
                        "Gia đình là nơi mùa xuân luôn hiện hữu.\n" + //
                        "\n" + //
                        "4. Xuân của tuổi trẻ\n" + //
                        "Nội dung\n" + //
                        "Ước mơ và hoài bão.\n" + //
                        "Sự khởi đầu mới.\n" + //
                        "Nhiệt huyết và thay đổi.\n" + //
                        "Bài học\n" + //
                        "\n" + //
                        "Tuổi trẻ là mùa xuân của đời người.\n" + //
                        "\n" + //
                        "5. Xuân và thời gian\n" + //
                        "Nội dung\n" + //
                        "Sự trôi chảy của thời gian.\n" + //
                        "Những mùa xuân đã qua.\n" + //
                        "Sự trưởng thành.\n" + //
                        "Bài học\n" + //
                        "\n" + //
                        "Thời gian không quay lại, nhưng ký ức luôn còn.\n" + //
                        "\n" + //
                        "6. Xuân trong tâm hồn\n" + //
                        "Nội dung\n" + //
                        "Niềm vui nội tâm.\n" + //
                        "Sự bình an.\n" + //
                        "Tư duy tích cực.\n" + //
                        "Bài học\n" + //
                        "\n" + //
                        "Khi tâm an, mỗi ngày đều là mùa xuân.\n" + //
                        "\n" + //
                        "7. Hy vọng và khởi đầu mới\n" + //
                        "Nội dung\n" + //
                        "Tinh thần đổi mới.\n" + //
                        "Vượt qua khó khăn.\n" + //
                        "Niềm tin vào tương lai.\n" + //
                        "Bài học\n" + //
                        "\n" + //
                        "Hy vọng là sức mạnh giúp con người tiến về phía trước.");
        // #endregion
        b24.setCategory(c3);
        b24.setAuthors(new ArrayList<>(Arrays.asList(a21)));
        b24.setCoverImage("/images/6383-xuan-trong-toi-1.webp");
        bookRepository.save(b24);

        //Category 4
        Book b25 = new Book();
        b25.setBookName("BỘ LUẬT DÂN SỰ");
        b25.setPublisher("Chính Trị Quốc Gia");
        b25.setYearPublish(2024);
        b25.setQuantity(5);
        b25.setBorrowCount(1);
        // #region Book Detail   
        b25.setBookDetail("Bộ Luật Dân Sự – Tóm tắt và các chương\n" + //
                        "\n" + //
                        "Bộ luật Dân sự (BLDS) là văn bản pháp luật nền tảng trong hệ thống pháp luật Việt Nam, quy định các quan hệ dân sự như: tài sản, hợp đồng, sở hữu, thừa kế, nghĩa vụ, và nhân thân.\n" + //
                        "\n" + //
                        "Bộ luật hiện hành là Bộ luật Dân sự 2015, gồm 6 phần lớn với 689 điều luật.\n" + //
                        "\n" + //
                        "Tóm tắt toàn bộ bộ luật\n" + //
                        "\n" + //
                        "Bộ luật Dân sự điều chỉnh các quan hệ xã hội dựa trên nguyên tắc:\n" + //
                        "\n" + //
                        "Bình đẳng giữa các chủ thể.\n" + //
                        "Tự do, tự nguyện cam kết, thỏa thuận.\n" + //
                        "Tôn trọng quyền sở hữu và quyền nhân thân.\n" + //
                        "Thiện chí, trung thực trong giao dịch.\n" + //
                        "\n" + //
                        "Mục tiêu là đảm bảo ổn định trật tự dân sự và bảo vệ quyền, lợi ích hợp pháp của cá nhân, tổ chức.\n" + //
                        "\n" + //
                        "Cấu trúc và các phần của Bộ luật Dân sự 2015\n" + //
                        "PHẦN 1. QUY ĐỊNH CHUNG\n" + //
                        "Nội dung\n" + //
                        "Nguyên tắc cơ bản của luật dân sự.\n" + //
                        "Năng lực pháp luật và năng lực hành vi dân sự.\n" + //
                        "Cá nhân, pháp nhân.\n" + //
                        "Đại diện.\n" + //
                        "Thời hiệu.\n" + //
                        "Ý nghĩa\n" + //
                        "\n" + //
                        "Đây là nền tảng áp dụng cho toàn bộ các quan hệ dân sự.\n" + //
                        "\n" + //
                        "PHẦN 2. TÀI SẢN VÀ QUYỀN SỞ HỮU\n" + //
                        "Nội dung\n" + //
                        "Khái niệm tài sản.\n" + //
                        "Quyền sở hữu.\n" + //
                        "Chiếm hữu, sử dụng, định đoạt.\n" + //
                        "Bảo vệ quyền sở hữu.\n" + //
                        "Các hình thức sở hữu.\n" + //
                        "Ý nghĩa\n" + //
                        "\n" + //
                        "Quy định ai sở hữu gì và quyền của họ đối với tài sản đó.\n" + //
                        "\n" + //
                        "PHẦN 3. NGHĨA VỤ VÀ HỢP ĐỒNG\n" + //
                        "Nội dung\n" + //
                        "Giao kết hợp đồng.\n" + //
                        "Thực hiện hợp đồng.\n" + //
                        "Trách nhiệm dân sự khi vi phạm.\n" + //
                        "Bồi thường thiệt hại.\n" + //
                        "Các loại hợp đồng dân sự.\n" + //
                        "Ý nghĩa\n" + //
                        "\n" + //
                        "Điều chỉnh các giao dịch mua bán, vay mượn, thuê mướn, dịch vụ…\n" + //
                        "\n" + //
                        "PHẦN 4. NGHĨA VỤ PHÁT SINH NGOÀI HỢP ĐỒNG\n" + //
                        "Nội dung\n" + //
                        "Bồi thường thiệt hại ngoài hợp đồng.\n" + //
                        "Trách nhiệm khi gây thiệt hại.\n" + //
                        "Chiếm hữu, sử dụng tài sản không có căn cứ pháp luật.\n" + //
                        "Ý nghĩa\n" + //
                        "\n" + //
                        "Xử lý các hành vi gây thiệt hại dù không có hợp đồng.\n" + //
                        "\n" + //
                        "PHẦN 5. THỪA KẾ\n" + //
                        "Nội dung\n" + //
                        "Thừa kế theo di chúc.\n" + //
                        "Thừa kế theo pháp luật.\n" + //
                        "Phân chia di sản.\n" + //
                        "Người thừa kế không phụ thuộc nội dung di chúc.\n" + //
                        "Từ chối nhận di sản.\n" + //
                        "Ý nghĩa\n" + //
                        "\n" + //
                        "Quy định việc chuyển tài sản của người đã mất cho người còn sống.\n" + //
                        "\n" + //
                        "PHẦN 6. QUY ĐỊNH ÁP DỤNG PHÁP LUẬT DÂN SỰ VÀ QUAN HỆ CÓ YẾU TỐ NƯỚC NGOÀI\n" + //
                        "Nội dung\n" + //
                        "Áp dụng pháp luật dân sự.\n" + //
                        "Quan hệ dân sự có yếu tố nước ngoài.\n" + //
                        "Xung đột pháp luật.\n" + //
                        "Quy tắc lựa chọn luật áp dụng.\n" + //
                        "Ý nghĩa\n" + //
                        "\n" + //
                        "Điều chỉnh các quan hệ dân sự quốc tế (ví dụ: người nước ngoài, tài sản ở nước ngoài).");
        // #endregion
        b25.setCategory(c4);
        b25.setAuthors(new ArrayList<>(Arrays.asList(a22)));
        b25.setCoverImage("/images/6047-bo-luat-dan-su-1.webp");
        bookRepository.save(b25);

        Book b26 = new Book();
        b26.setBookName("LUẬT DOANH NGHIỆP");
        b26.setPublisher("Lao Động");
        b26.setYearPublish(2024);
        b26.setQuantity(5);
        b26.setBorrowCount(4);
        // #region Book Detail   
        b26.setBookDetail("Luật Doanh Nghiệp – Tóm tắt và các chương\n" + //
                        "\n" + //
                        "Luật Doanh nghiệp (hiện hành: Luật Doanh nghiệp 2020) là văn bản pháp luật quan trọng quy định việc thành lập, tổ chức quản lý, hoạt động và giải thể doanh nghiệp tại Việt Nam.\n" + //
                        "\n" + //
                        "Luật này áp dụng cho các loại hình doanh nghiệp phổ biến như:\n" + //
                        "\n" + //
                        "Doanh nghiệp tư nhân\n" + //
                        "Công ty trách nhiệm hữu hạn (TNHH)\n" + //
                        "Công ty cổ phần\n" + //
                        "Công ty hợp danh\n" + //
                        "Tóm tắt toàn bộ luật\n" + //
                        "\n" + //
                        "Luật Doanh nghiệp nhằm:\n" + //
                        "\n" + //
                        "Tạo hành lang pháp lý cho hoạt động kinh doanh.\n" + //
                        "Bảo đảm quyền tự do kinh doanh của cá nhân, tổ chức.\n" + //
                        "Quy định rõ trách nhiệm, quyền hạn của doanh nghiệp và người quản lý.\n" + //
                        "Bảo vệ quyền lợi của nhà đầu tư, cổ đông và các bên liên quan.\n" + //
                        "\n" + //
                        "Nguyên tắc xuyên suốt là:\n" + //
                        "\n" + //
                        "Doanh nghiệp được tự do kinh doanh những ngành nghề pháp luật không cấm.\n" + //
                        "\n" + //
                        "Cấu trúc và các chương của Luật Doanh nghiệp 2020\n" + //
                        "\n" + //
                        "Luật gồm 10 chương, 218 điều.\n" + //
                        "\n" + //
                        "CHƯƠNG 1. NHỮNG QUY ĐỊNH CHUNG\n" + //
                        "Nội dung\n" + //
                        "Khái niệm doanh nghiệp.\n" + //
                        "Quyền tự do kinh doanh.\n" + //
                        "Nguyên tắc áp dụng luật.\n" + //
                        "Các hành vi bị cấm.\n" + //
                        "Ý nghĩa\n" + //
                        "\n" + //
                        "Đặt nền móng pháp lý cho toàn bộ hoạt động doanh nghiệp.\n" + //
                        "\n" + //
                        "CHƯƠNG 2. THÀNH LẬP DOANH NGHIỆP\n" + //
                        "Nội dung\n" + //
                        "Điều kiện thành lập.\n" + //
                        "Hồ sơ đăng ký doanh nghiệp.\n" + //
                        "Đăng ký kinh doanh.\n" + //
                        "Con dấu, tên doanh nghiệp.\n" + //
                        "Ý nghĩa\n" + //
                        "\n" + //
                        "Quy định cách một doanh nghiệp được hợp pháp hóa.\n" + //
                        "\n" + //
                        "CHƯƠNG 3. DOANH NGHIỆP TƯ NHÂN\n" + //
                        "Nội dung\n" + //
                        "Chủ sở hữu là một cá nhân.\n" + //
                        "Trách nhiệm vô hạn.\n" + //
                        "Quyền và nghĩa vụ của chủ doanh nghiệp.\n" + //
                        "Ý nghĩa\n" + //
                        "\n" + //
                        "Loại hình đơn giản nhất nhưng rủi ro tài chính cao.\n" + //
                        "\n" + //
                        "CHƯƠNG 4. CÔNG TY HỢP DANH\n" + //
                        "Nội dung\n" + //
                        "Ít nhất 2 thành viên hợp danh.\n" + //
                        "Thành viên hợp danh chịu trách nhiệm vô hạn.\n" + //
                        "Có thể có thành viên góp vốn.\n" + //
                        "Ý nghĩa\n" + //
                        "\n" + //
                        "Phù hợp ngành nghề cần uy tín cao (luật, kiểm toán…).\n" + //
                        "\n" + //
                        "CHƯƠNG 5. CÔNG TY TNHH HAI THÀNH VIÊN TRỞ LÊN\n" + //
                        "Nội dung\n" + //
                        "Từ 2 đến 50 thành viên.\n" + //
                        "Trách nhiệm hữu hạn trong phạm vi vốn góp.\n" + //
                        "Cơ cấu quản lý rõ ràng.\n" + //
                        "Ý nghĩa\n" + //
                        "\n" + //
                        "Loại hình phổ biến với doanh nghiệp vừa và nhỏ.\n" + //
                        "\n" + //
                        "CHƯƠNG 6. CÔNG TY TNHH MỘT THÀNH VIÊN\n" + //
                        "Nội dung\n" + //
                        "Một chủ sở hữu (cá nhân hoặc tổ chức).\n" + //
                        "Trách nhiệm hữu hạn.\n" + //
                        "Dễ quản lý.\n" + //
                        "Ý nghĩa\n" + //
                        "\n" + //
                        "Phù hợp doanh nghiệp nhỏ hoặc công ty con.\n" + //
                        "\n" + //
                        "CHƯƠNG 7. CÔNG TY CỔ PHẦN\n" + //
                        "Nội dung\n" + //
                        "Có tối thiểu 3 cổ đông.\n" + //
                        "Vốn chia thành cổ phần.\n" + //
                        "Có thể phát hành cổ phiếu.\n" + //
                        "Cơ cấu: Đại hội đồng cổ đông, HĐQT, Ban kiểm soát.\n" + //
                        "Ý nghĩa\n" + //
                        "\n" + //
                        "Loại hình phù hợp doanh nghiệp lớn, dễ huy động vốn.\n" + //
                        "\n" + //
                        "CHƯƠNG 8. DOANH NGHIỆP NHÀ NƯỚC\n" + //
                        "Nội dung\n" + //
                        "Do Nhà nước nắm giữ vốn chi phối.\n" + //
                        "Quản lý theo mô hình đặc thù.\n" + //
                        "Quy định về đại diện chủ sở hữu nhà nước.\n" + //
                        "Ý nghĩa\n" + //
                        "\n" + //
                        "Điều chỉnh doanh nghiệp thuộc sở hữu nhà nước.\n" + //
                        "\n" + //
                        "CHƯƠNG 9. TỔ CHỨC LẠI, GIẢI THỂ VÀ PHÁ SẢN\n" + //
                        "Nội dung\n" + //
                        "Sáp nhập, hợp nhất, chia, tách doanh nghiệp.\n" + //
                        "Giải thể tự nguyện hoặc bắt buộc.\n" + //
                        "Phá sản theo luật phá sản.\n" + //
                        "Ý nghĩa\n" + //
                        "\n" + //
                        "Quy định vòng đời của doanh nghiệp.\n" + //
                        "\n" + //
                        "CHƯƠNG 10. QUẢN LÝ NHÀ NƯỚC VỀ DOANH NGHIỆP\n" + //
                        "Nội dung\n" + //
                        "Vai trò cơ quan quản lý.\n" + //
                        "Thanh tra, kiểm tra doanh nghiệp.\n" + //
                        "Xử lý vi phạm.\n" + //
                        "Ý nghĩa\n" + //
                        "\n" + //
                        "Đảm bảo hoạt động doanh nghiệp đúng pháp luật.");
        // #endregion
        b26.setCategory(c4);
        b26.setAuthors(new ArrayList<>(Arrays.asList(a22)));
        b26.setCoverImage("/images/5801-luat-doanh-nghiep-1.webp");
        bookRepository.save(b26);

        Book b27 = new Book();
        b27.setBookName("LUẬT ĐẤT ĐAI");
        b27.setPublisher(" Công An Nhân Dân");
        b27.setYearPublish(2024);
        b27.setQuantity(5);
        b27.setBorrowCount(2);
        // #region Book Detail   
        b27.setBookDetail("Luật Đất Đai – Tóm tắt và các chương\n" + //
                        "\n" + //
                        "Luật Đất đai (hiện hành: Luật Đất đai 2024) là văn bản pháp luật quan trọng nhất điều chỉnh việc quản lý, sử dụng đất đai tại Việt Nam. Luật quy định về quyền của Nhà nước, quyền và nghĩa vụ của người sử dụng đất, cũng như các hoạt động như giao đất, cho thuê đất, thu hồi đất, cấp giấy chứng nhận quyền sử dụng đất.\n" + //
                        "\n" + //
                        "Tóm tắt toàn bộ luật\n" + //
                        "\n" + //
                        "Luật Đất đai quy định rằng:\n" + //
                        "\n" + //
                        "Đất đai thuộc sở hữu toàn dân, do Nhà nước đại diện quản lý.\n" + //
                        "Nhà nước thống nhất quản lý và phân bổ đất đai theo quy hoạch.\n" + //
                        "Người dân, tổ chức được giao quyền sử dụng đất, không phải quyền sở hữu tuyệt đối.\n" + //
                        "Quyền sử dụng đất có thể được chuyển nhượng, thừa kế, cho thuê, thế chấp theo luật.\n" + //
                        "\n" + //
                        "Mục tiêu chính là:\n" + //
                        "\n" + //
                        "Sử dụng đất đúng mục đích, hiệu quả, công bằng và bền vững.\n" + //
                        "\n" + //
                        "Cấu trúc và các chương của Luật Đất đai 2024\n" + //
                        "\n" + //
                        "Luật Đất đai 2024 gồm 16 chương và hơn 260 điều.\n" + //
                        "\n" + //
                        "CHƯƠNG 1. NHỮNG QUY ĐỊNH CHUNG\n" + //
                        "Nội dung\n" + //
                        "Nguyên tắc quản lý đất đai.\n" + //
                        "Sở hữu toàn dân về đất đai.\n" + //
                        "Giải thích thuật ngữ.\n" + //
                        "Ý nghĩa\n" + //
                        "\n" + //
                        "Đặt nền tảng cho toàn bộ hệ thống pháp luật đất đai.\n" + //
                        "\n" + //
                        "CHƯƠNG 2. QUYỀN VÀ NGHĨA VỤ CỦA NGƯỜI SỬ DỤNG ĐẤT\n" + //
                        "Nội dung\n" + //
                        "Quyền chuyển nhượng, thừa kế, tặng cho.\n" + //
                        "Nghĩa vụ tài chính.\n" + //
                        "Quyền khi Nhà nước thu hồi đất.\n" + //
                        "Ý nghĩa\n" + //
                        "\n" + //
                        "Xác định quyền lợi hợp pháp của người dân và doanh nghiệp.\n" + //
                        "\n" + //
                        "CHƯƠNG 3. QUY HOẠCH, KẾ HOẠCH SỬ DỤNG ĐẤT\n" + //
                        "Nội dung\n" + //
                        "Lập quy hoạch đất.\n" + //
                        "Kế hoạch sử dụng đất theo giai đoạn.\n" + //
                        "Công khai quy hoạch.\n" + //
                        "Ý nghĩa\n" + //
                        "\n" + //
                        "Định hướng phát triển đất đai theo chiến lược quốc gia.\n" + //
                        "\n" + //
                        "CHƯƠNG 4. GIAO ĐẤT, CHO THUÊ ĐẤT, CHUYỂN MỤC ĐÍCH SỬ DỤNG ĐẤT\n" + //
                        "Nội dung\n" + //
                        "Điều kiện giao và thuê đất.\n" + //
                        "Đấu giá quyền sử dụng đất.\n" + //
                        "Chuyển mục đích sử dụng đất.\n" + //
                        "Ý nghĩa\n" + //
                        "\n" + //
                        "Điều chỉnh việc phân bổ đất cho cá nhân và tổ chức.\n" + //
                        "\n" + //
                        "CHƯƠNG 5. THU HỒI ĐẤT VÀ BỒI THƯỜNG\n" + //
                        "Nội dung\n" + //
                        "Các trường hợp thu hồi đất.\n" + //
                        "Chính sách bồi thường, hỗ trợ, tái định cư.\n" + //
                        "Ý nghĩa\n" + //
                        "\n" + //
                        "Đảm bảo công bằng khi Nhà nước thu hồi đất vì lợi ích công cộng.\n" + //
                        "\n" + //
                        "CHƯƠNG 6. ĐĂNG KÝ ĐẤT ĐAI, CẤP GIẤY CHỨNG NHẬN\n" + //
                        "Nội dung\n" + //
                        "Sổ đỏ (Giấy chứng nhận quyền sử dụng đất).\n" + //
                        "Đăng ký biến động đất đai.\n" + //
                        "Hồ sơ địa chính.\n" + //
                        "Ý nghĩa\n" + //
                        "\n" + //
                        "Xác lập quyền hợp pháp đối với đất.\n" + //
                        "\n" + //
                        "CHƯƠNG 7. TÀI CHÍNH ĐẤT ĐAI VÀ GIÁ ĐẤT\n" + //
                        "Nội dung\n" + //
                        "Bảng giá đất.\n" + //
                        "Thuế, phí liên quan đất đai.\n" + //
                        "Định giá đất.\n" + //
                        "Ý nghĩa\n" + //
                        "\n" + //
                        "Tạo cơ sở cho giao dịch và bồi thường.\n" + //
                        "\n" + //
                        "CHƯƠNG 8. HỆ THỐNG THÔNG TIN ĐẤT ĐAI\n" + //
                        "Nội dung\n" + //
                        "Cơ sở dữ liệu đất đai.\n" + //
                        "Số hóa bản đồ đất.\n" + //
                        "Ý nghĩa\n" + //
                        "\n" + //
                        "Hiện đại hóa quản lý đất đai.\n" + //
                        "\n" + //
                        "CHƯƠNG 9. CHẾ ĐỘ SỬ DỤNG CÁC LOẠI ĐẤT\n" + //
                        "Nội dung\n" + //
                        "Đất nông nghiệp.\n" + //
                        "Đất phi nông nghiệp.\n" + //
                        "Đất chưa sử dụng.\n" + //
                        "Ý nghĩa\n" + //
                        "\n" + //
                        "Quy định mục đích sử dụng từng loại đất.\n" + //
                        "\n" + //
                        "CHƯƠNG 10. QUYỀN HẠN VÀ TRÁCH NHIỆM CƠ QUAN NHÀ NƯỚC\n" + //
                        "Nội dung\n" + //
                        "Vai trò Chính phủ, UBND các cấp.\n" + //
                        "Quản lý đất đai.\n" + //
                        "Ý nghĩa\n" + //
                        "\n" + //
                        "Phân cấp quản lý rõ ràng.\n" + //
                        "\n" + //
                        "CHƯƠNG 11. THANH TRA, KIỂM TRA, GIẢI QUYẾT TRANH CHẤP\n" + //
                        "Nội dung\n" + //
                        "Giải quyết khiếu nại đất đai.\n" + //
                        "Thanh tra vi phạm.\n" + //
                        "Ý nghĩa\n" + //
                        "\n" + //
                        "Bảo vệ quyền lợi người sử dụng đất.\n" + //
                        "\n" + //
                        "CHƯƠNG 12. HỢP ĐỒNG VÀ GIAO DỊCH ĐẤT ĐAI\n" + //
                        "Nội dung\n" + //
                        "Chuyển nhượng, cho thuê, thế chấp quyền sử dụng đất.\n" + //
                        "Công chứng hợp đồng.\n" + //
                        "Ý nghĩa\n" + //
                        "\n" + //
                        "Hợp pháp hóa giao dịch đất đai.\n" + //
                        "\n" + //
                        "CHƯƠNG 13. THỊ TRƯỜNG QUYỀN SỬ DỤNG ĐẤT\n" + //
                        "Nội dung\n" + //
                        "Hoạt động mua bán, chuyển nhượng.\n" + //
                        "Quản lý thị trường bất động sản.\n" + //
                        "Ý nghĩa\n" + //
                        "\n" + //
                        "Điều tiết thị trường đất đai.\n" + //
                        "\n" + //
                        "CHƯƠNG 14. ĐẤT ĐAI Ở NÔNG THÔN VÀ ĐÔ THỊ\n" + //
                        "Nội dung\n" + //
                        "Quy định riêng cho từng khu vực.\n" + //
                        "Phát triển đô thị, nông thôn.\n" + //
                        "CHƯƠNG 15. GIẢI QUYẾT TRANH CHẤP ĐẤT ĐAI\n" + //
                        "Nội dung\n" + //
                        "Hòa giải.\n" + //
                        "Tòa án.\n" + //
                        "Khiếu nại hành chính.\n" + //
                        "CHƯƠNG 16. ĐIỀU KHOẢN THI HÀNH\n" + //
                        "Nội dung\n" + //
                        "Hiệu lực luật.\n" + //
                        "Quy định chuyển tiếp");
        // #endregion
        b27.setCategory(c4);
        b27.setAuthors(new ArrayList<>(Arrays.asList(a22)));
        b27.setCoverImage("/images/6052-luat-dat-dai-1.webp");
        bookRepository.save(b27);

        Book b28 = new Book();
        b28.setBookName("GIÁO TRÌNH LUẬT THƯƠNG MẠI QUỐC TẾ");
        b28.setPublisher("Hồng Đức");
        b28.setYearPublish(2024);
        b28.setQuantity(5);
        b28.setBorrowCount(1);
        // #region Book Detail   
        b28.setBookDetail("Giáo Trình Luật Thương Mại Quốc Tế – Tóm tắt và các chương\n" + //
                        "\n" + //
                        "Giáo trình Luật Thương mại Quốc tế là tài liệu học thuật dùng trong các trường đại học luật và kinh tế, nghiên cứu các quy định điều chỉnh hoạt động mua bán hàng hóa, dịch vụ, đầu tư và giải quyết tranh chấp xuyên biên giới.\n" + //
                        "\n" + //
                        "Giáo trình thường dựa trên các nguồn luật như:\n" + //
                        "\n" + //
                        "Công ước Viên 1980 (CISG)\n" + //
                        "WTO (Tổ chức Thương mại Thế giới)\n" + //
                        "Luật quốc gia về thương mại\n" + //
                        "Tập quán thương mại quốc tế (Incoterms, UCP…)\n" + //
                        "Tóm tắt toàn bộ giáo trình\n" + //
                        "\n" + //
                        "Luật thương mại quốc tế nghiên cứu cách thức:\n" + //
                        "\n" + //
                        "Các quốc gia và doanh nghiệp giao dịch xuyên biên giới.\n" + //
                        "Quy định về hợp đồng quốc tế.\n" + //
                        "Vận chuyển, thanh toán quốc tế.\n" + //
                        "Giải quyết tranh chấp thương mại.\n" + //
                        "Bảo vệ quyền lợi trong môi trường toàn cầu hóa.\n" + //
                        "\n" + //
                        "Mục tiêu:\n" + //
                        "\n" + //
                        "Tạo hành lang pháp lý cho thương mại toàn cầu công bằng, minh bạch và ổn định.\n" + //
                        "\n" + //
                        "Cấu trúc và các chương của giáo trình\n" + //
                        "\n" + //
                        "Thông thường giáo trình gồm 8–10 chương.\n" + //
                        "\n" + //
                        "CHƯƠNG 1. TỔNG QUAN VỀ LUẬT THƯƠNG MẠI QUỐC TẾ\n" + //
                        "Nội dung\n" + //
                        "Khái niệm thương mại quốc tế.\n" + //
                        "Nguồn luật quốc tế.\n" + //
                        "Nguyên tắc điều chỉnh.\n" + //
                        "Ý nghĩa\n" + //
                        "\n" + //
                        "Giới thiệu nền tảng hệ thống pháp luật thương mại toàn cầu.\n" + //
                        "\n" + //
                        "CHƯƠNG 2. CHỦ THỂ TRONG THƯƠNG MẠI QUỐC TẾ\n" + //
                        "Nội dung\n" + //
                        "Quốc gia.\n" + //
                        "Doanh nghiệp.\n" + //
                        "Tổ chức quốc tế.\n" + //
                        "Ý nghĩa\n" + //
                        "\n" + //
                        "Xác định ai có quyền tham gia giao dịch quốc tế.\n" + //
                        "\n" + //
                        "CHƯƠNG 3. HỢP ĐỒNG THƯƠNG MẠI QUỐC TẾ\n" + //
                        "Nội dung\n" + //
                        "Giao kết hợp đồng.\n" + //
                        "Điều kiện hợp đồng.\n" + //
                        "Hiệu lực hợp đồng.\n" + //
                        "CISG (Công ước Viên).\n" + //
                        "Ý nghĩa\n" + //
                        "\n" + //
                        "Nền tảng của mọi giao dịch quốc tế.\n" + //
                        "\n" + //
                        "CHƯƠNG 4. MUA BÁN HÀNG HÓA QUỐC TẾ\n" + //
                        "Nội dung\n" + //
                        "Quyền và nghĩa vụ bên mua/bán.\n" + //
                        "Giao hàng, rủi ro.\n" + //
                        "Incoterms.\n" + //
                        "Ý nghĩa\n" + //
                        "\n" + //
                        "Điều chỉnh hoạt động xuất nhập khẩu.\n" + //
                        "\n" + //
                        "CHƯƠNG 5. THANH TOÁN QUỐC TẾ\n" + //
                        "Nội dung\n" + //
                        "Tín dụng chứng từ (L/C).\n" + //
                        "Nhờ thu.\n" + //
                        "Chuyển tiền quốc tế.\n" + //
                        "Ý nghĩa\n" + //
                        "\n" + //
                        "Đảm bảo an toàn tài chính trong giao dịch.\n" + //
                        "\n" + //
                        "CHƯƠNG 6. VẬN CHUYỂN VÀ BẢO HIỂM HÀNG HÓA QUỐC TẾ\n" + //
                        "Nội dung\n" + //
                        "Vận tải biển, hàng không.\n" + //
                        "Hợp đồng vận chuyển.\n" + //
                        "Bảo hiểm hàng hóa.\n" + //
                        "Ý nghĩa\n" + //
                        "\n" + //
                        "Giảm rủi ro trong logistics toàn cầu.\n" + //
                        "\n" + //
                        "CHƯƠNG 7. ĐẦU TƯ QUỐC TẾ\n" + //
                        "Nội dung\n" + //
                        "Đầu tư trực tiếp (FDI).\n" + //
                        "Đầu tư gián tiếp.\n" + //
                        "Bảo hộ đầu tư.\n" + //
                        "Ý nghĩa\n" + //
                        "\n" + //
                        "Thu hút và điều chỉnh dòng vốn quốc tế.\n" + //
                        "\n" + //
                        "CHƯƠNG 8. GIẢI QUYẾT TRANH CHẤP THƯƠNG MẠI QUỐC TẾ\n" + //
                        "Nội dung\n" + //
                        "Trọng tài quốc tế.\n" + //
                        "Tòa án quốc tế.\n" + //
                        "Hòa giải thương mại.\n" + //
                        "Ý nghĩa\n" + //
                        "\n" + //
                        "Giải quyết xung đột giữa các bên quốc tế.\n" + //
                        "\n" + //
                        "CHƯƠNG 9. WTO VÀ HỆ THỐNG THƯƠNG MẠI TOÀN CẦU\n" + //
                        "Nội dung\n" + //
                        "Nguyên tắc WTO.\n" + //
                        "Tự do thương mại.\n" + //
                        "Chống bán phá giá.\n" + //
                        "Ý nghĩa\n" + //
                        "\n" + //
                        "Điều tiết thương mại giữa các quốc gia.\n" + //
                        "\n" + //
                        "CHƯƠNG 10. TẬP QUÁN VÀ LUẬT MỀM TRONG THƯƠNG MẠI QUỐC TẾ\n" + //
                        "Nội dung\n" + //
                        "Incoterms.\n" + //
                        "UCP 600.\n" + //
                        "Lex mercatoria (luật thương mại quốc tế phi chính thức).\n" + //
                        "Ý nghĩa\n" + //
                        "\n" + //
                        "Điều chỉnh linh hoạt các giao dịch quốc tế.");
        // #endregion
        b28.setCategory(c4);
        b28.setAuthors(new ArrayList<>(Arrays.asList(a23)));
        b28.setCoverImage("/images/3833-giao-trinh-luat-thuong-mai-quoc-te-1.webp");
        bookRepository.save(b28);

        Book b29 = new Book();
        b29.setBookName("GIÁO TRÌNH LUẬT TỐ TỤNG HÌNH SỰ VIỆT NAM");
        b29.setPublisher("Hồng Đức");
        b29.setYearPublish(2024);
        b29.setQuantity(5);
        b29.setBorrowCount(3);
        // #region Book Detail   
        b29.setBookDetail("Giáo trình Luật Tố tụng Hình sự Việt Nam – Tóm tắt và các chương\n" + //
                        "\n" + //
                        "Giáo trình Luật Tố tụng Hình sự Việt Nam là tài liệu học thuật nghiên cứu toàn bộ quy trình giải quyết vụ án hình sự: từ khi khởi tố, điều tra, truy tố, xét xử đến thi hành án.\n" + //
                        "\n" + //
                        "Cơ sở pháp lý chính là Bộ luật Tố tụng Hình sự 2015 (sửa đổi, bổ sung 2021).\n" + //
                        "\n" + //
                        "Tóm tắt toàn bộ giáo trình\n" + //
                        "\n" + //
                        "Luật tố tụng hình sự quy định:\n" + //
                        "\n" + //
                        "Cách thức phát hiện tội phạm.\n" + //
                        "Quy trình điều tra, truy tố, xét xử.\n" + //
                        "Quyền và nghĩa vụ của người tham gia tố tụng.\n" + //
                        "Vai trò của cơ quan tiến hành tố tụng.\n" + //
                        "Bảo đảm quyền con người và công lý.\n" + //
                        "\n" + //
                        "Mục tiêu:\n" + //
                        "\n" + //
                        "Phát hiện chính xác tội phạm, xử lý đúng người đúng tội, không làm oan sai hoặc bỏ lọt tội phạm.\n" + //
                        "\n" + //
                        "Cấu trúc và các chương của giáo trình\n" + //
                        "\n" + //
                        "Giáo trình thường chia theo phần tương ứng Bộ luật Tố tụng Hình sự 2015, gồm các nhóm nội dung lớn sau:\n" + //
                        "\n" + //
                        "CHƯƠNG 1. NHỮNG QUY ĐỊNH CHUNG\n" + //
                        "Nội dung\n" + //
                        "Khái niệm tố tụng hình sự.\n" + //
                        "Nguyên tắc cơ bản (suy đoán vô tội, tranh tụng…).\n" + //
                        "Thẩm quyền của cơ quan tiến hành tố tụng.\n" + //
                        "Ý nghĩa\n" + //
                        "\n" + //
                        "Tạo nền tảng cho toàn bộ quá trình tố tụng.\n" + //
                        "\n" + //
                        "CHƯƠNG 2. CƠ QUAN VÀ NGƯỜI TIẾN HÀNH TỐ TỤNG\n" + //
                        "Nội dung\n" + //
                        "Cơ quan điều tra.\n" + //
                        "Viện kiểm sát.\n" + //
                        "Tòa án.\n" + //
                        "Điều tra viên, kiểm sát viên, thẩm phán.\n" + //
                        "Ý nghĩa\n" + //
                        "\n" + //
                        "Xác định bộ máy thực thi pháp luật hình sự.\n" + //
                        "\n" + //
                        "CHƯƠNG 3. NGƯỜI THAM GIA TỐ TỤNG\n" + //
                        "Nội dung\n" + //
                        "Bị can, bị cáo.\n" + //
                        "Người bị hại.\n" + //
                        "Luật sư, người bào chữa.\n" + //
                        "Người làm chứng, giám định viên.\n" + //
                        "Ý nghĩa\n" + //
                        "\n" + //
                        "Bảo đảm quyền lợi và vai trò của các bên liên quan.\n" + //
                        "\n" + //
                        "CHƯƠNG 4. CHỨNG CỨ VÀ CHỨNG MINH\n" + //
                        "Nội dung\n" + //
                        "Khái niệm chứng cứ.\n" + //
                        "Thu thập và đánh giá chứng cứ.\n" + //
                        "Nghĩa vụ chứng minh thuộc về cơ quan tiến hành tố tụng.\n" + //
                        "Ý nghĩa\n" + //
                        "\n" + //
                        "Là nền tảng để xác định sự thật vụ án.\n" + //
                        "\n" + //
                        "CHƯƠNG 5. BIỆN PHÁP NGĂN CHẶN\n" + //
                        "Nội dung\n" + //
                        "Bắt người.\n" + //
                        "Tạm giữ, tạm giam.\n" + //
                        "Cấm đi khỏi nơi cư trú.\n" + //
                        "Bảo lĩnh.\n" + //
                        "Ý nghĩa\n" + //
                        "\n" + //
                        "Ngăn ngừa tội phạm bỏ trốn hoặc gây cản trở điều tra.\n" + //
                        "\n" + //
                        "CHƯƠNG 6. KHỞI TỐ, ĐIỀU TRA VỤ ÁN HÌNH SỰ\n" + //
                        "Nội dung\n" + //
                        "Tiếp nhận tin báo tội phạm.\n" + //
                        "Khởi tố vụ án, bị can.\n" + //
                        "Hoạt động điều tra.\n" + //
                        "Ý nghĩa\n" + //
                        "\n" + //
                        "Giai đoạn thu thập chứng cứ ban đầu.\n" + //
                        "\n" + //
                        "CHƯƠNG 7. TRUY TỐ\n" + //
                        "Nội dung\n" + //
                        "Vai trò Viện kiểm sát.\n" + //
                        "Cáo trạng.\n" + //
                        "Quyết định truy tố hoặc đình chỉ.\n" + //
                        "Ý nghĩa\n" + //
                        "\n" + //
                        "Chuyển vụ án sang giai đoạn xét xử.\n" + //
                        "\n" + //
                        "CHƯƠNG 8. XÉT XỬ SƠ THẨM\n" + //
                        "Nội dung\n" + //
                        "Phiên tòa sơ thẩm.\n" + //
                        "Tranh tụng tại tòa.\n" + //
                        "Bản án sơ thẩm.\n" + //
                        "Ý nghĩa\n" + //
                        "\n" + //
                        "Giai đoạn xét xử đầu tiên và quan trọng nhất.\n" + //
                        "\n" + //
                        "CHƯƠNG 9. PHÚC THẨM, GIÁM ĐỐC THẨM, TÁI THẨM\n" + //
                        "Nội dung\n" + //
                        "Kháng cáo, kháng nghị.\n" + //
                        "Xét xử lại vụ án.\n" + //
                        "Ý nghĩa\n" + //
                        "\n" + //
                        "Bảo đảm công lý và sửa sai nếu có.\n" + //
                        "\n" + //
                        "CHƯƠNG 10. THI HÀNH ÁN HÌNH SỰ\n" + //
                        "Nội dung\n" + //
                        "Thi hành bản án.\n" + //
                        "Cơ quan thi hành án hình sự.\n" + //
                        "Chấp hành hình phạt tù, cải tạo…\n" + //
                        "Ý nghĩa\n" + //
                        "\n" + //
                        "Biến bản án thành thực tế.\n" + //
                        "\n" + //
                        "CHƯƠNG 11. BIỆN PHÁP ĐẶC BIỆT VÀ THỦ TỤC ĐẶC BIỆT\n" + //
                        "Nội dung\n" + //
                        "Tố tụng đối với người chưa thành niên.\n" + //
                        "Rút gọn thủ tục.\n" + //
                        "Vụ án đặc biệt.\n" + //
                        "Ý nghĩa\n" + //
                        "\n" + //
                        "Xử lý linh hoạt theo từng loại vụ án.");
        // #endregion
        b29.setCategory(c4);
        b29.setAuthors(new ArrayList<>(Arrays.asList(a24)));
        b29.setCoverImage("/images/15926-giao-trinh-luat-to-tung-hinh-su-viet-nam-1.webp");
        bookRepository.save(b29);

        Book b30 = new Book();
        b30.setBookName("PHÁP LUẬT ĐẠI CƯƠNG");
        b30.setPublisher("Hồng Đức");
        b30.setYearPublish(2024);
        b30.setQuantity(5);
        b30.setBorrowCount(1);
        // #region Book Detail   
        b30.setBookDetail("Pháp Luật Đại Cương – Tóm tắt và các chương\n" + //
                        "\n" + //
                        "Pháp luật đại cương là môn học nền tảng trong các ngành luật và kinh tế, cung cấp kiến thức cơ bản về nhà nước, pháp luật và hệ thống pháp lý Việt Nam.\n" + //
                        "\n" + //
                        "Môn học này không phải “một bộ luật cụ thể” mà là giáo trình lý thuyết tổng quan về pháp luật.\n" + //
                        "\n" + //
                        "Tóm tắt toàn bộ môn học\n" + //
                        "\n" + //
                        "Pháp luật đại cương nghiên cứu:\n" + //
                        "\n" + //
                        "Bản chất và vai trò của nhà nước.\n" + //
                        "Nguồn gốc và chức năng của pháp luật.\n" + //
                        "Hệ thống pháp luật Việt Nam.\n" + //
                        "Quan hệ pháp luật và thực hiện pháp luật.\n" + //
                        "Vi phạm pháp luật và trách nhiệm pháp lý.\n" + //
                        "\n" + //
                        "Mục tiêu:\n" + //
                        "\n" + //
                        "Giúp người học hiểu cách pháp luật được hình thành, vận hành và tác động đến đời sống xã hội.\n" + //
                        "\n" + //
                        "Cấu trúc và các chương của giáo trình\n" + //
                        "\n" + //
                        "Thông thường gồm 6–9 chương, tùy từng trường.\n" + //
                        "\n" + //
                        "CHƯƠNG 1. NHÀ NƯỚC VÀ PHÁP LUẬT\n" + //
                        "Nội dung\n" + //
                        "Nguồn gốc nhà nước.\n" + //
                        "Bản chất nhà nước.\n" + //
                        "Mối quan hệ giữa nhà nước và pháp luật.\n" + //
                        "Ý nghĩa\n" + //
                        "\n" + //
                        "Đặt nền tảng lý luận cho toàn bộ môn học.\n" + //
                        "\n" + //
                        "CHƯƠNG 2. NGUỒN GỐC VÀ BẢN CHẤT CỦA PHÁP LUẬT\n" + //
                        "Nội dung\n" + //
                        "Khái niệm pháp luật.\n" + //
                        "Nguồn gốc hình thành pháp luật.\n" + //
                        "Đặc điểm của pháp luật.\n" + //
                        "Ý nghĩa\n" + //
                        "\n" + //
                        "Giải thích pháp luật là gì và vì sao tồn tại.\n" + //
                        "\n" + //
                        "CHƯƠNG 3. QUY PHẠM PHÁP LUẬT VÀ HỆ THỐNG PHÁP LUẬT\n" + //
                        "Nội dung\n" + //
                        "Cấu trúc quy phạm pháp luật.\n" + //
                        "Hệ thống ngành luật (dân sự, hình sự…).\n" + //
                        "Văn bản quy phạm pháp luật.\n" + //
                        "Ý nghĩa\n" + //
                        "\n" + //
                        "Hiểu cách pháp luật được tổ chức.\n" + //
                        "\n" + //
                        "CHƯƠNG 4. QUAN HỆ PHÁP LUẬT\n" + //
                        "Nội dung\n" + //
                        "Chủ thể pháp luật.\n" + //
                        "Khách thể.\n" + //
                        "Nội dung quan hệ pháp luật.\n" + //
                        "Ý nghĩa\n" + //
                        "\n" + //
                        "Giải thích cách pháp luật điều chỉnh hành vi con người.\n" + //
                        "\n" + //
                        "CHƯƠNG 5. THỰC HIỆN PHÁP LUẬT\n" + //
                        "Nội dung\n" + //
                        "Tuân thủ pháp luật.\n" + //
                        "Thi hành pháp luật.\n" + //
                        "Áp dụng pháp luật.\n" + //
                        "Ý nghĩa\n" + //
                        "\n" + //
                        "Pháp luật chỉ có hiệu lực khi được thực hiện.\n" + //
                        "\n" + //
                        "CHƯƠNG 6. VI PHẠM PHÁP LUẬT\n" + //
                        "Nội dung\n" + //
                        "Khái niệm vi phạm.\n" + //
                        "Các yếu tố cấu thành.\n" + //
                        "Các loại vi phạm.\n" + //
                        "Ý nghĩa\n" + //
                        "\n" + //
                        "Nhận diện hành vi trái pháp luật.\n" + //
                        "\n" + //
                        "CHƯƠNG 7. TRÁCH NHIỆM PHÁP LÝ\n" + //
                        "Nội dung\n" + //
                        "Trách nhiệm hình sự, dân sự, hành chính.\n" + //
                        "Nguyên tắc xử lý.\n" + //
                        "Ý nghĩa\n" + //
                        "\n" + //
                        "Hậu quả pháp lý của hành vi vi phạm.\n" + //
                        "\n" + //
                        "CHƯƠNG 8. PHÁP CHẾ XÃ HỘI CHỦ NGHĨA\n" + //
                        "Nội dung\n" + //
                        "Khái niệm pháp chế.\n" + //
                        "Nguyên tắc thượng tôn pháp luật.\n" + //
                        "Vai trò nhà nước pháp quyền.\n" + //
                        "Ý nghĩa\n" + //
                        "\n" + //
                        "Xây dựng xã hội công bằng và kỷ cương.");
        // #endregion
        b30.setCategory(c4);
        b30.setAuthors(new ArrayList<>(Arrays.asList(a25)));
        b30.setCoverImage("/images/5518-phap-luat-dai-cuong-1.webp");
        bookRepository.save(b30);

        Book b31 = new Book();
        b31.setBookName("TẬP BÀI GIẢNG LÝ LUẬN VỀ PHÁP LUẬT");
        b31.setPublisher(" Khoa Học Xã Hội");
        b31.setYearPublish(2019);
        b31.setQuantity(5);
        b31.setBorrowCount(2);
        // #region Book Detail   
        b31.setBookDetail("Tập Bài Giảng Lý Luận Về Pháp Luật – Tóm tắt và các chương\n" + //
                        "\n" + //
                        "“Tập bài giảng Lý luận về pháp luật” là tài liệu học thuật thuộc nhóm môn Lý luận Nhà nước và Pháp luật, thường dùng trong các trường đại học luật. Nội dung tập trung phân tích sâu hơn so với “Pháp luật đại cương”, đi vào bản chất, chức năng và cơ chế vận hành của pháp luật trong xã hội.\n" + //
                        "\n" + //
                        "Tóm tắt toàn bộ sách\n" + //
                        "\n" + //
                        "Tài liệu nghiên cứu:\n" + //
                        "\n" + //
                        "Bản chất giai cấp và xã hội của pháp luật.\n" + //
                        "Mối quan hệ giữa pháp luật với kinh tế, chính trị, đạo đức.\n" + //
                        "Cơ chế hình thành và thực hiện pháp luật.\n" + //
                        "Vai trò của pháp luật trong nhà nước pháp quyền.\n" + //
                        "\n" + //
                        "Mục tiêu:\n" + //
                        "\n" + //
                        "Giải thích “pháp luật là gì, vì sao tồn tại, và nó vận hành như thế nào trong xã hội” ở mức lý luận sâu hơn.\n" + //
                        "\n" + //
                        "Cấu trúc và các chương (dạng phổ biến trong giáo trình)\n" + //
                        "\n" + //
                        "Tùy trường đại học, bố cục có thể khác nhau, nhưng thường gồm 7–10 chương.\n" + //
                        "\n" + //
                        "CHƯƠNG 1. KHÁI NIỆM VÀ BẢN CHẤT CỦA PHÁP LUẬT\n" + //
                        "Nội dung\n" + //
                        "Khái niệm pháp luật dưới góc nhìn khoa học.\n" + //
                        "Bản chất giai cấp và bản chất xã hội.\n" + //
                        "Đặc trưng của pháp luật so với đạo đức, tập quán.\n" + //
                        "Ý nghĩa\n" + //
                        "\n" + //
                        "Giải thích nền tảng lý luận của pháp luật.\n" + //
                        "\n" + //
                        "CHƯƠNG 2. NGUỒN GỐC VÀ SỰ HÌNH THÀNH PHÁP LUẬT\n" + //
                        "Nội dung\n" + //
                        "Sự ra đời của nhà nước và pháp luật.\n" + //
                        "Quá trình phát triển lịch sử pháp luật.\n" + //
                        "Các kiểu pháp luật trong lịch sử.\n" + //
                        "Ý nghĩa\n" + //
                        "\n" + //
                        "Hiểu pháp luật là sản phẩm của xã hội có tổ chức.\n" + //
                        "\n" + //
                        "CHƯƠNG 3. CHỨC NĂNG CỦA PHÁP LUẬT\n" + //
                        "Nội dung\n" + //
                        "Chức năng điều chỉnh xã hội.\n" + //
                        "Chức năng bảo vệ trật tự xã hội.\n" + //
                        "Chức năng giáo dục và định hướng hành vi.\n" + //
                        "Ý nghĩa\n" + //
                        "\n" + //
                        "Giải thích vai trò của pháp luật trong đời sống.\n" + //
                        "\n" + //
                        "CHƯƠNG 4. HỆ THỐNG PHÁP LUẬT\n" + //
                        "Nội dung\n" + //
                        "Ngành luật và chế định pháp luật.\n" + //
                        "Cấu trúc hệ thống pháp luật quốc gia.\n" + //
                        "Văn bản quy phạm pháp luật.\n" + //
                        "Ý nghĩa\n" + //
                        "\n" + //
                        "Phân loại và tổ chức pháp luật.\n" + //
                        "\n" + //
                        "CHƯƠNG 5. QUY PHẠM PHÁP LUẬT\n" + //
                        "Nội dung\n" + //
                        "Cấu trúc: giả định – quy định – chế tài.\n" + //
                        "Phân loại quy phạm pháp luật.\n" + //
                        "Hiệu lực của quy phạm.\n" + //
                        "Ý nghĩa\n" + //
                        "\n" + //
                        "Đơn vị cơ bản của hệ thống pháp luật.\n" + //
                        "\n" + //
                        "CHƯƠNG 6. THỰC HIỆN PHÁP LUẬT\n" + //
                        "Nội dung\n" + //
                        "Tuân thủ, thi hành, sử dụng, áp dụng pháp luật.\n" + //
                        "Cơ chế đưa pháp luật vào đời sống.\n" + //
                        "Ý nghĩa\n" + //
                        "\n" + //
                        "Pháp luật chỉ có giá trị khi được thực hiện.\n" + //
                        "\n" + //
                        "CHƯƠNG 7. ÁP DỤNG PHÁP LUẬT\n" + //
                        "Nội dung\n" + //
                        "Chủ thể áp dụng pháp luật.\n" + //
                        "Trình tự áp dụng.\n" + //
                        "Văn bản áp dụng pháp luật.\n" + //
                        "Ý nghĩa\n" + //
                        "\n" + //
                        "Cách nhà nước thực thi pháp luật trong thực tế.\n" + //
                        "\n" + //
                        "CHƯƠNG 8. Ý THỨC PHÁP LUẬT\n" + //
                        "Nội dung\n" + //
                        "Khái niệm ý thức pháp luật.\n" + //
                        "Cấu trúc: tri thức – tình cảm – hành vi.\n" + //
                        "Vai trò trong xã hội.\n" + //
                        "Ý nghĩa\n" + //
                        "\n" + //
                        "Pháp luật phụ thuộc vào nhận thức con người.\n" + //
                        "\n" + //
                        "CHƯƠNG 9. PHÁP LUẬT VÀ NHÀ NƯỚC PHÁP QUYỀN\n" + //
                        "Nội dung\n" + //
                        "Khái niệm nhà nước pháp quyền.\n" + //
                        "Nguyên tắc thượng tôn pháp luật.\n" + //
                        "Kiểm soát quyền lực nhà nước.\n" + //
                        "Ý nghĩa\n" + //
                        "\n" + //
                        "Mô hình nhà nước hiện đại.\n" + //
                        "\n" + //
                        "CHƯƠNG 10. MỐI QUAN HỆ CỦA PHÁP LUẬT VỚI CÁC HIỆN TƯỢNG XÃ HỘI\n" + //
                        "Nội dung\n" + //
                        "Pháp luật và kinh tế.\n" + //
                        "Pháp luật và chính trị.\n" + //
                        "Pháp luật và đạo đức.\n" + //
                        "Ý nghĩa\n" + //
                        "\n" + //
                        "Pháp luật không tồn tại độc lập mà gắn với xã hội.");
        // #endregion
        b31.setCategory(c4);
        b31.setAuthors(new ArrayList<>(Arrays.asList(a22)));
        b31.setCoverImage("/images/2485-tap-bai-giang-ly-luan-ve-phap-luat-1.webp");
        bookRepository.save(b31);

        Book b32 = new Book();
        b32.setBookName("LUẬT SO SÁNH");
        b32.setPublisher("Trẻ");
        b32.setYearPublish(2006);
        b32.setQuantity(5);
        b32.setBorrowCount(3);
        // #region Book Detail   
        b32.setBookDetail("Luật So Sánh – Tóm tắt và các chương\n" + //
                        "\n" + //
                        "Luật So Sánh (Comparative Law) là môn học nghiên cứu, đối chiếu các hệ thống pháp luật khác nhau trên thế giới nhằm tìm ra điểm giống và khác, từ đó hiểu sâu hơn về pháp luật quốc gia và xu hướng pháp lý toàn cầu.\n" + //
                        "\n" + //
                        "Tóm tắt toàn bộ sách\n" + //
                        "\n" + //
                        "Môn Luật So Sánh tập trung vào:\n" + //
                        "\n" + //
                        "So sánh các hệ thống pháp luật lớn trên thế giới.\n" + //
                        "Phân tích nguồn gốc và đặc điểm của từng hệ thống.\n" + //
                        "Tìm hiểu sự ảnh hưởng lẫn nhau giữa các hệ thống pháp luật.\n" + //
                        "Hỗ trợ cải cách pháp luật quốc gia.\n" + //
                        "Nhận diện xu hướng toàn cầu hóa pháp luật.\n" + //
                        "\n" + //
                        "Mục tiêu:\n" + //
                        "\n" + //
                        "Giúp người học hiểu pháp luật không chỉ trong nước mà trong bối cảnh quốc tế.\n" + //
                        "\n" + //
                        "Cấu trúc và các chương của giáo trình Luật So Sánh\n" + //
                        "\n" + //
                        "Thông thường giáo trình gồm 7–9 chương.\n" + //
                        "\n" + //
                        "CHƯƠNG 1. KHÁI QUÁT VỀ LUẬT SO SÁNH\n" + //
                        "Nội dung\n" + //
                        "Khái niệm luật so sánh.\n" + //
                        "Mục đích và vai trò.\n" + //
                        "Đối tượng nghiên cứu.\n" + //
                        "Ý nghĩa\n" + //
                        "\n" + //
                        "Giới thiệu nền tảng và lý do cần so sánh pháp luật.\n" + //
                        "\n" + //
                        "CHƯƠNG 2. PHƯƠNG PHÁP LUẬT SO SÁNH\n" + //
                        "Nội dung\n" + //
                        "Phương pháp chức năng.\n" + //
                        "Phương pháp cấu trúc.\n" + //
                        "Phương pháp lịch sử – văn hóa.\n" + //
                        "Ý nghĩa\n" + //
                        "\n" + //
                        "Cách tiếp cận khoa học khi so sánh pháp luật.\n" + //
                        "\n" + //
                        "CHƯƠNG 3. CÁC HỆ THỐNG PHÁP LUẬT TRÊN THẾ GIỚI\n" + //
                        "Nội dung\n" + //
                        "Hệ thống Civil Law (châu Âu lục địa).\n" + //
                        "Common Law (Anh – Mỹ).\n" + //
                        "Hệ thống Hồi giáo (Sharia).\n" + //
                        "Hệ thống xã hội chủ nghĩa.\n" + //
                        "Hệ thống pháp luật hỗn hợp.\n" + //
                        "Ý nghĩa\n" + //
                        "\n" + //
                        "Phân loại các “gia đình pháp luật”.\n" + //
                        "\n" + //
                        "CHƯƠNG 4. HỆ THỐNG CIVIL LAW\n" + //
                        "Nội dung\n" + //
                        "Nguồn luật: luật thành văn.\n" + //
                        "Vai trò của bộ luật.\n" + //
                        "Tòa án áp dụng luật.\n" + //
                        "Ý nghĩa\n" + //
                        "\n" + //
                        "Hệ thống phổ biến ở châu Âu và Việt Nam.\n" + //
                        "\n" + //
                        "CHƯƠNG 5. HỆ THỐNG COMMON LAW\n" + //
                        "Nội dung\n" + //
                        "Tiền lệ pháp (precedent).\n" + //
                        "Vai trò của thẩm phán.\n" + //
                        "Án lệ bắt buộc.\n" + //
                        "Ý nghĩa\n" + //
                        "\n" + //
                        "Phổ biến ở Anh, Mỹ và nhiều nước thuộc khối Anh ngữ.\n" + //
                        "\n" + //
                        "CHƯƠNG 6. SO SÁNH PHÁP LUẬT DÂN SỰ VÀ HÌNH SỰ\n" + //
                        "Nội dung\n" + //
                        "Khác biệt về mục đích.\n" + //
                        "Cấu trúc quy phạm.\n" + //
                        "Thủ tục tố tụng.\n" + //
                        "Ý nghĩa\n" + //
                        "\n" + //
                        "Hiểu cách các nước xử lý tranh chấp và tội phạm khác nhau.\n" + //
                        "\n" + //
                        "CHƯƠNG 7. LUẬT HỢP ĐỒNG TRONG CÁC HỆ THỐNG\n" + //
                        "Nội dung\n" + //
                        "Nguyên tắc tự do hợp đồng.\n" + //
                        "Điều kiện hiệu lực.\n" + //
                        "Vi phạm hợp đồng.\n" + //
                        "Ý nghĩa\n" + //
                        "\n" + //
                        "Cho thấy sự hội tụ trong thương mại toàn cầu.\n" + //
                        "\n" + //
                        "CHƯƠNG 8. CƠ QUAN TÀI PHÁN VÀ HỆ THỐNG TÒA ÁN\n" + //
                        "Nội dung\n" + //
                        "Tòa án trong Civil Law và Common Law.\n" + //
                        "Vai trò thẩm phán và bồi thẩm đoàn.\n" + //
                        "Cơ chế xét xử.\n" + //
                        "Ý nghĩa\n" + //
                        "\n" + //
                        "So sánh cách tổ chức tư pháp.\n" + //
                        "\n" + //
                        "CHƯƠNG 9. XU HƯỚNG TOÀN CẦU HÓA PHÁP LUẬT\n" + //
                        "Nội dung\n" + //
                        "Hài hòa hóa pháp luật quốc tế.\n" + //
                        "Ảnh hưởng của WTO, EU.\n" + //
                        "Luật thương mại quốc tế.\n" + //
                        "Ý nghĩa\n" + //
                        "\n" + //
                        "Pháp luật đang ngày càng hội nhập");
        // #endregion
        b32.setCategory(c4);
        b32.setAuthors(new ArrayList<>(Arrays.asList(a26)));
        b32.setCoverImage("/images/2511-luat-so-sanh-1.webp");
        bookRepository.save(b32);

        //Category 5
        Book b33 = new Book();
        b33.setBookName("AI 5.0 - NHANH HƠN, DỄ HƠN, RẺ HƠN, CHÍNH XÁC HƠN");
        b33.setPublisher("Công Thương");
        b33.setYearPublish(2024);
        b33.setQuantity(5);
        b33.setBorrowCount(2);
        // #region Book Detail   
        b33.setBookDetail("“AI 5.0 – Nhanh hơn, Dễ hơn, Rẻ hơn, Chính xác hơn”\n" + //
                        "Tóm tắt và các chương\n" + //
                        "\n" + //
                        "⚠️ Lưu ý: Tên sách này không thuộc một giáo trình chuẩn hay tác phẩm học thuật phổ biến có cấu trúc cố định. Vì vậy, phần dưới đây là bản tóm tắt theo hướng nội dung giả lập/khái quát thường gặp của các sách về AI thế hệ mới (AI 5.0), dựa trên cách phân chia logic trong lĩnh vực trí tuệ nhân tạo hiện đại.\n" + //
                        "\n" + //
                        "Tóm tắt toàn bộ nội dung\n" + //
                        "\n" + //
                        "Cuốn sách (theo chủ đề AI 5.0) thường xoay quanh ý tưởng:\n" + //
                        "\n" + //
                        "Trí tuệ nhân tạo thế hệ mới sẽ trở nên phổ biến hơn, rẻ hơn, dễ sử dụng hơn và chính xác hơn, giúp AI đi vào mọi lĩnh vực đời sống.\n" + //
                        "\n" + //
                        "Nội dung tập trung vào:\n" + //
                        "\n" + //
                        "Sự tiến hóa từ AI 1.0 → AI 5.0\n" + //
                        "Tự động hóa tri thức và công việc\n" + //
                        "AI trong kinh doanh, giáo dục, y tế, pháp luật\n" + //
                        "Tối ưu chi phí và tăng tốc xử lý dữ liệu\n" + //
                        "AI cá nhân hóa cho từng người dùng\n" + //
                        "Rủi ro đạo đức, pháp lý và xã hội của AI\n" + //
                        "Cấu trúc và các chương (giả lập theo logic sách AI hiện đại)\n" + //
                        "CHƯƠNG 1. KHÁI NIỆM AI 5.0\n" + //
                        "Nội dung\n" + //
                        "AI 5.0 là gì\n" + //
                        "Khác biệt với AI 1.0–4.0\n" + //
                        "Xu hướng “AI phổ cập”\n" + //
                        "Ý nghĩa\n" + //
                        "\n" + //
                        "Đặt nền tảng về thế hệ AI mới: dễ dùng và đại chúng hóa.\n" + //
                        "\n" + //
                        "CHƯƠNG 2. TIẾN HÓA CỦA TRÍ TUỆ NHÂN TẠO\n" + //
                        "Nội dung\n" + //
                        "AI dựa trên luật (Rule-based)\n" + //
                        "Machine Learning\n" + //
                        "Deep Learning\n" + //
                        "Generative AI\n" + //
                        "AI 5.0: AI tích hợp đa mô hình + tự động hóa toàn diện\n" + //
                        "Ý nghĩa\n" + //
                        "\n" + //
                        "Giải thích quá trình phát triển công nghệ AI.\n" + //
                        "\n" + //
                        "CHƯƠNG 3. “NHANH HƠN” – TỐI ƯU TỐC ĐỘ XỬ LÝ\n" + //
                        "Nội dung\n" + //
                        "Tăng tốc xử lý dữ liệu lớn\n" + //
                        "Edge AI và cloud AI\n" + //
                        "Giảm độ trễ trong phản hồi\n" + //
                        "Ý nghĩa\n" + //
                        "\n" + //
                        "AI phản hồi gần như thời gian thực.\n" + //
                        "\n" + //
                        "CHƯƠNG 4. “RẺ HƠN” – PHỔ CẬP HÓA AI\n" + //
                        "Nội dung\n" + //
                        "Giảm chi phí huấn luyện mô hình\n" + //
                        "AI-as-a-Service\n" + //
                        "Mở rộng AI cho doanh nghiệp nhỏ\n" + //
                        "Ý nghĩa\n" + //
                        "\n" + //
                        "AI không còn là công nghệ đắt đỏ.\n" + //
                        "\n" + //
                        "CHƯƠNG 5. “DỄ HƠN” – DÂN CHỦ HÓA CÔNG NGHỆ\n" + //
                        "Nội dung\n" + //
                        "No-code / low-code AI\n" + //
                        "Trợ lý AI cá nhân\n" + //
                        "AI trong ứng dụng đời sống\n" + //
                        "Ý nghĩa\n" + //
                        "\n" + //
                        "Ai cũng có thể sử dụng AI mà không cần lập trình.\n" + //
                        "\n" + //
                        "CHƯƠNG 6. “CHÍNH XÁC HƠN” – TĂNG ĐỘ TIN CẬY\n" + //
                        "Nội dung\n" + //
                        "Giảm hallucination (ảo giác AI)\n" + //
                        "Fine-tuning theo dữ liệu cá nhân\n" + //
                        "AI có khả năng tự kiểm chứng\n" + //
                        "Ý nghĩa\n" + //
                        "\n" + //
                        "AI trở nên đáng tin cậy hơn trong các quyết định quan trọng.\n" + //
                        "\n" + //
                        "CHƯƠNG 7. AI TRONG DOANH NGHIỆP\n" + //
                        "Nội dung\n" + //
                        "Tự động hóa marketing, bán hàng\n" + //
                        "Phân tích dữ liệu khách hàng\n" + //
                        "Tối ưu vận hành\n" + //
                        "Ý nghĩa\n" + //
                        "\n" + //
                        "AI trở thành “nhân sự số” trong doanh nghiệp.\n" + //
                        "\n" + //
                        "CHƯƠNG 8. AI TRONG ĐỜI SỐNG\n" + //
                        "Nội dung\n" + //
                        "Giáo dục cá nhân hóa\n" + //
                        "Y tế thông minh\n" + //
                        "Nhà thông minh\n" + //
                        "Trợ lý cá nhân AI\n" + //
                        "Ý nghĩa\n" + //
                        "\n" + //
                        "AI trở thành hạ tầng đời sống.\n" + //
                        "\n" + //
                        "CHƯƠNG 9. RỦI RO VÀ ĐẠO ĐỨC AI\n" + //
                        "Nội dung\n" + //
                        "Mất việc làm\n" + //
                        "Quyền riêng tư dữ liệu\n" + //
                        "AI thiên lệch (bias)\n" + //
                        "Kiểm soát AI mạnh\n" + //
                        "Ý nghĩa\n" + //
                        "\n" + //
                        "Cảnh báo mặt trái của AI phát triển nhanh.\n" + //
                        "\n" + //
                        "CHƯƠNG 10. TƯƠNG LAI AI 6.0\n" + //
                        "Nội dung\n" + //
                        "AI tự học liên tục\n" + //
                        "AI đa tác nhân (multi-agent systems)\n" + //
                        "AI gần mức trí tuệ con người (AGI hướng tới)\n" + //
                        "Ý nghĩa\n" + //
                        "\n" + //
                        "Dự báo tương lai xa hơn của công nghệ.");
        // #endregion
        b33.setCategory(c5);
        b33.setAuthors(new ArrayList<>(Arrays.asList(a27)));
        b33.setCoverImage("/images/6048-ai-50-nhanh-hon-de-hon-re-hon-chinh-xac-hon-1.webp");
        bookRepository.save(b33);

        Book b34 = new Book();
        b34.setBookName("CHATGPT - ỨNG DỤNG TRÍ TUỆ NHÂN TẠO TRONG CÔNG VIỆC");
        b34.setPublisher("Công Thương");
        b34.setYearPublish(2024);
        b34.setQuantity(5);
        b34.setBorrowCount(5);
        // #region Book Detail   
        b34.setBookDetail("ChatGPT – Ứng Dụng Trí Tuệ Nhân Tạo Trong Công Việc\n" + //
                        "Tóm tắt và các chương\n" + //
                        "\n" + //
                        "⚠️ Lưu ý: Đây không phải một “giáo trình chuẩn cố định”, mà là dạng sách hướng dẫn/ứng dụng AI (ChatGPT) nên cấu trúc có thể thay đổi theo từng tác giả. Dưới đây là bản tổng hợp theo logic phổ biến của các sách về ChatGPT trong công việc.\n" + //
                        "\n" + //
                        "Tóm tắt toàn bộ nội dung\n" + //
                        "\n" + //
                        "Cuốn sách tập trung vào việc:\n" + //
                        "\n" + //
                        "Hướng dẫn cách sử dụng ChatGPT như một công cụ AI để tăng năng suất, tự động hóa công việc và hỗ trợ ra quyết định trong nhiều lĩnh vực.\n" + //
                        "\n" + //
                        "Nội dung chính gồm:\n" + //
                        "\n" + //
                        "ChatGPT là gì và hoạt động như thế nào\n" + //
                        "Cách viết prompt hiệu quả\n" + //
                        "Ứng dụng AI trong công việc văn phòng, kinh doanh, học tập\n" + //
                        "Tự động hóa quy trình làm việc\n" + //
                        "Tạo nội dung (content, email, báo cáo, code)\n" + //
                        "Giới hạn và rủi ro khi dùng AI\n" + //
                        "Cấu trúc và các chương\n" + //
                        "CHƯƠNG 1. GIỚI THIỆU VỀ CHATGPT VÀ AI SINH NGÔN NGỮ\n" + //
                        "Nội dung\n" + //
                        "ChatGPT là gì\n" + //
                        "AI ngôn ngữ hoạt động ra sao\n" + //
                        "Sự khác biệt giữa ChatGPT và tìm kiếm Google\n" + //
                        "Ý nghĩa\n" + //
                        "\n" + //
                        "Giúp người đọc hiểu nền tảng công nghệ.\n" + //
                        "\n" + //
                        "CHƯƠNG 2. CÁCH CHATGPT HIỂU VÀ XỬ LÝ THÔNG TIN\n" + //
                        "Nội dung\n" + //
                        "Mô hình ngôn ngữ lớn (LLM)\n" + //
                        "Dự đoán từ tiếp theo\n" + //
                        "Giới hạn kiến thức và “ảo giác AI”\n" + //
                        "Ý nghĩa\n" + //
                        "\n" + //
                        "Hiểu đúng để dùng đúng.\n" + //
                        "\n" + //
                        "CHƯƠNG 3. KỸ THUẬT VIẾT PROMPT HIỆU QUẢ\n" + //
                        "Nội dung\n" + //
                        "Prompt là gì\n" + //
                        "Cấu trúc prompt tốt (vai trò – nhiệm vụ – ngữ cảnh – yêu cầu)\n" + //
                        "Ví dụ prompt trong công việc\n" + //
                        "Ý nghĩa\n" + //
                        "\n" + //
                        "Đây là “kỹ năng cốt lõi” khi dùng ChatGPT.\n" + //
                        "\n" + //
                        "CHƯƠNG 4. ỨNG DỤNG TRONG CÔNG VIỆC VĂN PHÒNG\n" + //
                        "Nội dung\n" + //
                        "Viết email\n" + //
                        "Soạn báo cáo\n" + //
                        "Tóm tắt tài liệu\n" + //
                        "Lập kế hoạch công việc\n" + //
                        "Ý nghĩa\n" + //
                        "\n" + //
                        "Giúp tăng năng suất hành chính.\n" + //
                        "\n" + //
                        "CHƯƠNG 5. CHATGPT TRONG MARKETING VÀ KINH DOANH\n" + //
                        "Nội dung\n" + //
                        "Viết content quảng cáo\n" + //
                        "Ý tưởng marketing\n" + //
                        "Phân tích khách hàng\n" + //
                        "Viết kịch bản bán hàng\n" + //
                        "Ý nghĩa\n" + //
                        "\n" + //
                        "AI hỗ trợ tăng doanh thu và giảm chi phí.\n" + //
                        "\n" + //
                        "CHƯƠNG 6. CHATGPT TRONG HỌC TẬP VÀ NGHIÊN CỨU\n" + //
                        "Nội dung\n" + //
                        "Giải thích bài học\n" + //
                        "Tóm tắt sách\n" + //
                        "Học ngoại ngữ\n" + //
                        "Hỗ trợ viết luận\n" + //
                        "Ý nghĩa\n" + //
                        "\n" + //
                        "Cá nhân hóa giáo dục.\n" + //
                        "\n" + //
                        "CHƯƠNG 7. TỰ ĐỘNG HÓA CÔNG VIỆC VỚI AI\n" + //
                        "Nội dung\n" + //
                        "Kết hợp ChatGPT với API\n" + //
                        "Workflow tự động\n" + //
                        "AI agents\n" + //
                        "Tích hợp công cụ (Excel, Notion, Zapier…)\n" + //
                        "Ý nghĩa\n" + //
                        "\n" + //
                        "Biến AI thành “trợ lý tự động”.\n" + //
                        "\n" + //
                        "CHƯƠNG 8. ỨNG DỤNG CHATGPT TRONG LẬP TRÌNH\n" + //
                        "Nội dung\n" + //
                        "Viết code\n" + //
                        "Debug lỗi\n" + //
                        "Giải thích thuật toán\n" + //
                        "Tạo project nhanh\n" + //
                        "Ý nghĩa\n" + //
                        "\n" + //
                        "Hỗ trợ lập trình viên tăng tốc phát triển phần mềm.\n" + //
                        "\n" + //
                        "CHƯƠNG 9. GIỚI HẠN VÀ RỦI RO\n" + //
                        "Nội dung\n" + //
                        "Sai thông tin (hallucination)\n" + //
                        "Vấn đề bảo mật dữ liệu\n" + //
                        "Phụ thuộc vào AI\n" + //
                        "Đạo đức sử dụng AI\n" + //
                        "Ý nghĩa\n" + //
                        "\n" + //
                        "Giúp sử dụng AI có trách nhiệm.\n" + //
                        "\n" + //
                        "CHƯƠNG 10. TƯƠNG LAI CÔNG VIỆC VỚI CHATGPT\n" + //
                        "Nội dung\n" + //
                        "AI thay đổi thị trường lao động\n" + //
                        "Kỹ năng cần thiết trong tương lai\n" + //
                        "Con người + AI hợp tác\n" + //
                        "Ý nghĩa\n" + //
                        "\n" + //
                        "Định hướng nghề nghiệp thời đại AI.");
        // #endregion
        b34.setCategory(c5);
        b34.setAuthors(new ArrayList<>(Arrays.asList(a27)));
        b34.setCoverImage("/images/6050-chatgpt-ung-dung-tri-tue-nhan-tao-trong-cong-viec-1.webp");
        bookRepository.save(b34);
        
        Book b35 = new Book();
        b35.setBookName("AI - CÔNG CỤ NÂNG CAO HIỆU SUẤT CÔNG VIỆC");
        b35.setPublisher("Công Thương");
        b35.setYearPublish(2024);
        b35.setQuantity(5);
        b35.setBorrowCount(4);
        // #region Book Detail   
        b35.setBookDetail("AI – Công Cụ Nâng Cao Hiệu Suất Công Việc\n" + //
                        "Tóm tắt và các chương\n" + //
                        "\n" + //
                        "⚠️ Lưu ý: Đây không phải một giáo trình cố định, mà thường là dạng sách kỹ năng / ứng dụng AI trong công việc, nên cấu trúc dưới đây là bản tổng hợp theo logic phổ biến của các tài liệu về AI và năng suất làm việc.\n" + //
                        "\n" + //
                        "Tóm tắt toàn bộ nội dung\n" + //
                        "\n" + //
                        "Cuốn sách tập trung vào việc:\n" + //
                        "\n" + //
                        "Sử dụng trí tuệ nhân tạo như một công cụ giúp con người làm việc nhanh hơn, chính xác hơn, tự động hóa nhiều tác vụ và tăng hiệu suất tổng thể.\n" + //
                        "\n" + //
                        "Nội dung chính gồm:\n" + //
                        "\n" + //
                        "AI giúp giảm thời gian làm việc lặp lại\n" + //
                        "Tự động hóa quy trình văn phòng và kinh doanh\n" + //
                        "Tăng chất lượng quyết định nhờ phân tích dữ liệu\n" + //
                        "Hỗ trợ sáng tạo nội dung và xử lý thông tin\n" + //
                        "Kết hợp AI + con người để tối ưu hiệu suất\n" + //
                        "Cấu trúc và các chương\n" + //
                        "CHƯƠNG 1. GIỚI THIỆU VỀ AI VÀ HIỆU SUẤT CÔNG VIỆC\n" + //
                        "Nội dung\n" + //
                        "AI là gì trong bối cảnh công việc\n" + //
                        "Hiệu suất lao động là gì\n" + //
                        "Vì sao AI trở thành công cụ tăng năng suất\n" + //
                        "Ý nghĩa\n" + //
                        "\n" + //
                        "Hiểu vai trò của AI trong môi trường hiện đại.\n" + //
                        "\n" + //
                        "CHƯƠNG 2. AI VÀ TỰ ĐỘNG HÓA CÔNG VIỆC\n" + //
                        "Nội dung\n" + //
                        "Tự động hóa quy trình (workflow automation)\n" + //
                        "AI xử lý công việc lặp lại\n" + //
                        "Ví dụ trong văn phòng và doanh nghiệp\n" + //
                        "Ý nghĩa\n" + //
                        "\n" + //
                        "Giảm thời gian cho công việc thủ công.\n" + //
                        "\n" + //
                        "CHƯƠNG 3. AI TRONG QUẢN LÝ THỜI GIAN\n" + //
                        "Nội dung\n" + //
                        "Lập kế hoạch bằng AI\n" + //
                        "Ưu tiên công việc thông minh\n" + //
                        "Trợ lý AI cá nhân\n" + //
                        "Ý nghĩa\n" + //
                        "\n" + //
                        "Giúp làm việc khoa học hơn.\n" + //
                        "\n" + //
                        "CHƯƠNG 4. AI TRONG XỬ LÝ THÔNG TIN\n" + //
                        "Nội dung\n" + //
                        "Tóm tắt tài liệu\n" + //
                        "Phân tích dữ liệu\n" + //
                        "Tìm kiếm và tổng hợp thông tin nhanh\n" + //
                        "Ý nghĩa\n" + //
                        "\n" + //
                        "Rút ngắn thời gian xử lý thông tin.\n" + //
                        "\n" + //
                        "CHƯƠNG 5. AI TRONG SÁNG TẠO NỘI DUNG\n" + //
                        "Nội dung\n" + //
                        "Viết email, báo cáo, bài viết\n" + //
                        "Tạo ý tưởng marketing\n" + //
                        "Thiết kế nội dung số\n" + //
                        "Ý nghĩa\n" + //
                        "\n" + //
                        "Tăng tốc sáng tạo nội dung.\n" + //
                        "\n" + //
                        "CHƯƠNG 6. AI TRONG DOANH NGHIỆP\n" + //
                        "Nội dung\n" + //
                        "AI trong bán hàng\n" + //
                        "AI trong chăm sóc khách hàng\n" + //
                        "AI phân tích dữ liệu kinh doanh\n" + //
                        "Ý nghĩa\n" + //
                        "\n" + //
                        "Tối ưu doanh thu và vận hành.\n" + //
                        "\n" + //
                        "CHƯƠNG 7. AI TRONG PHÂN TÍCH VÀ RA QUYẾT ĐỊNH\n" + //
                        "Nội dung\n" + //
                        "Phân tích dữ liệu lớn\n" + //
                        "Dự đoán xu hướng\n" + //
                        "Hỗ trợ ra quyết định\n" + //
                        "Ý nghĩa\n" + //
                        "\n" + //
                        "Giảm sai lầm trong quản lý.\n" + //
                        "\n" + //
                        "CHƯƠNG 8. CÔNG CỤ AI PHỔ BIẾN\n" + //
                        "Nội dung\n" + //
                        "ChatGPT và AI ngôn ngữ\n" + //
                        "AI tạo ảnh\n" + //
                        "AI phân tích dữ liệu\n" + //
                        "AI tự động hóa (Zapier, Notion AI…)\n" + //
                        "Ý nghĩa\n" + //
                        "\n" + //
                        "Giới thiệu hệ sinh thái AI.\n" + //
                        "\n" + //
                        "CHƯƠNG 9. GIỚI HẠN VÀ RỦI RO CỦA AI\n" + //
                        "Nội dung\n" + //
                        "Sai lệch thông tin\n" + //
                        "Phụ thuộc vào AI\n" + //
                        "Rủi ro bảo mật dữ liệu\n" + //
                        "Vấn đề đạo đức\n" + //
                        "Ý nghĩa\n" + //
                        "\n" + //
                        "Sử dụng AI một cách an toàn.\n" + //
                        "\n" + //
                        "CHƯƠNG 10. TƯƠNG LAI CÔNG VIỆC VỚI AI\n" + //
                        "Nội dung\n" + //
                        "AI thay đổi thị trường lao động\n" + //
                        "Kỹ năng mới cần thiết\n" + //
                        "Mô hình “con người + AI”\n" + //
                        "Ý nghĩa\n" + //
                        "\n" + //
                        "Định hướng tương lai nghề nghiệp.");
        // #endregion
        b35.setCategory(c5);
        b35.setAuthors(new ArrayList<>(Arrays.asList(a27)));
        b35.setCoverImage("/images/6049-ai-cong-cu-nang-cao-hieu-suat-cong-viec-1.webp");
        bookRepository.save(b35);

        Book b36 = new Book();
        b36.setBookName("BLOCKCHAIN VÀ TƯƠNG LAI CỦA TIỀN TỆ");
        b36.setPublisher("Lao Động");
        b36.setYearPublish(2024);
        b36.setQuantity(5);
        b36.setBorrowCount(2);
        // #region Book Detail   
        b36.setBookDetail("Blockchain và Tương Lai của Tiền Tệ\n" + //
                        "Tóm tắt và các chương\n" + //
                        "\n" + //
                        "⚠️ Lưu ý: Đây là một chủ đề sách phổ biến về công nghệ tài chính (fintech). Không có một giáo trình “chuẩn duy nhất”, nên nội dung dưới đây là bản tổng hợp theo logic thường gặp của các sách về blockchain và tiền số.\n" + //
                        "\n" + //
                        "Tóm tắt toàn bộ nội dung\n" + //
                        "\n" + //
                        "Cuốn sách tập trung vào việc giải thích:\n" + //
                        "\n" + //
                        "Blockchain là công nghệ nền tảng đang thay đổi cách tiền tệ, giao dịch và hệ thống tài chính vận hành trong tương lai.\n" + //
                        "\n" + //
                        "Nội dung chính gồm:\n" + //
                        "\n" + //
                        "Blockchain là gì và cách hoạt động\n" + //
                        "Bitcoin và các loại tiền mã hóa\n" + //
                        "Sự thay đổi của hệ thống ngân hàng truyền thống\n" + //
                        "Ứng dụng blockchain trong tài chính và đời sống\n" + //
                        "Rủi ro, pháp lý và biến động thị trường crypto\n" + //
                        "Tương lai của tiền tệ số (CBDC, DeFi, Web3)\n" + //
                        "Cấu trúc và các chương\n" + //
                        "CHƯƠNG 1. KHÁI NIỆM VỀ BLOCKCHAIN\n" + //
                        "Nội dung\n" + //
                        "Blockchain là gì\n" + //
                        "Cấu trúc chuỗi khối (block – chain)\n" + //
                        "Tính phi tập trung (decentralization)\n" + //
                        "Ý nghĩa\n" + //
                        "\n" + //
                        "Giải thích nền tảng công nghệ.\n" + //
                        "\n" + //
                        "CHƯƠNG 2. CÁCH BLOCKCHAIN HOẠT ĐỘNG\n" + //
                        "Nội dung\n" + //
                        "Giao dịch được ghi nhận như thế nào\n" + //
                        "Mạng lưới node\n" + //
                        "Cơ chế đồng thuận (Proof of Work, Proof of Stake)\n" + //
                        "Ý nghĩa\n" + //
                        "\n" + //
                        "Hiểu cách dữ liệu được xác thực và lưu trữ.\n" + //
                        "\n" + //
                        "CHƯƠNG 3. BITCOIN VÀ TIỀN MÃ HÓA\n" + //
                        "Nội dung\n" + //
                        "Bitcoin là gì\n" + //
                        "Altcoin (Ethereum, Solana…)\n" + //
                        "Ví điện tử (wallet)\n" + //
                        "Ý nghĩa\n" + //
                        "\n" + //
                        "Giới thiệu hệ sinh thái crypto.\n" + //
                        "\n" + //
                        "CHƯƠNG 4. NGÂN HÀNG VÀ HỆ THỐNG TÀI CHÍNH TRUYỀN THỐNG\n" + //
                        "Nội dung\n" + //
                        "Vai trò ngân hàng trung gian\n" + //
                        "Thanh toán quốc tế\n" + //
                        "Hạn chế của hệ thống cũ\n" + //
                        "Ý nghĩa\n" + //
                        "\n" + //
                        "So sánh với blockchain.\n" + //
                        "\n" + //
                        "CHƯƠNG 5. TÀI CHÍNH PHI TẬP TRUNG (DEFI)\n" + //
                        "Nội dung\n" + //
                        "Lending, borrowing trên blockchain\n" + //
                        "Smart contract\n" + //
                        "Sàn giao dịch phi tập trung (DEX)\n" + //
                        "Ý nghĩa\n" + //
                        "\n" + //
                        "Loại bỏ trung gian tài chính.\n" + //
                        "\n" + //
                        "CHƯƠNG 6. SMART CONTRACT VÀ ỨNG DỤNG\n" + //
                        "Nội dung\n" + //
                        "Hợp đồng thông minh\n" + //
                        "Tự động hóa giao dịch\n" + //
                        "Ứng dụng trong bảo hiểm, bất động sản\n" + //
                        "Ý nghĩa\n" + //
                        "\n" + //
                        "Tự động hóa tài chính.\n" + //
                        "\n" + //
                        "CHƯƠNG 7. NFT VÀ TÀI SẢN SỐ\n" + //
                        "Nội dung\n" + //
                        "NFT là gì\n" + //
                        "Quyền sở hữu tài sản số\n" + //
                        "Ứng dụng trong nghệ thuật, game\n" + //
                        "Ý nghĩa\n" + //
                        "\n" + //
                        "Mở rộng khái niệm tài sản.\n" + //
                        "\n" + //
                        "CHƯƠNG 8. RỦI RO VÀ THÁCH THỨC\n" + //
                        "Nội dung\n" + //
                        "Biến động giá mạnh\n" + //
                        "Lừa đảo và scam\n" + //
                        "Quy định pháp lý chưa rõ ràng\n" + //
                        "Tiêu thụ năng lượng\n" + //
                        "Ý nghĩa\n" + //
                        "\n" + //
                        "Cảnh báo rủi ro công nghệ mới.\n" + //
                        "\n" + //
                        "CHƯƠNG 9. QUY ĐỊNH VÀ PHÁP LÝ\n" + //
                        "Nội dung\n" + //
                        "Chính sách tiền số của các quốc gia\n" + //
                        "Thuế crypto\n" + //
                        "Kiểm soát tài chính\n" + //
                        "Ý nghĩa\n" + //
                        "\n" + //
                        "Blockchain cần khung pháp lý rõ ràng.\n" + //
                        "\n" + //
                        "CHƯƠNG 10. TƯƠNG LAI CỦA TIỀN TỆ\n" + //
                        "Nội dung\n" + //
                        "Tiền kỹ thuật số của ngân hàng trung ương (CBDC)\n" + //
                        "Xã hội không tiền mặt\n" + //
                        "Web3 và kinh tế số\n" + //
                        "Tích hợp AI + blockchain\n" + //
                        "Ý nghĩa\n" + //
                        "\n" + //
                        "Dự báo hệ thống tài chính mới");
        // #endregion
        b36.setCategory(c5);
        b36.setAuthors(new ArrayList<>(Arrays.asList(a29)));
        b36.setCoverImage("/images/12932-truth-machine-blockchain-va-tuong-lai-cua-tien-te-the-1.webp");
        bookRepository.save(b36);

        Book b37 = new Book();
        b37.setBookName("TÀI LIỆU ÔN TẬP TIN HỌC CƠ BẢN");
        b37.setPublisher("Công Thương");
        b37.setYearPublish(2024);
        b37.setQuantity(5);
        b37.setBorrowCount(2);
        // #region Book Detail   
        b37.setBookDetail("Tài Liệu Ôn Tập Tin Học Cơ Bản\n" + //
                        "Tóm tắt và các chương\n" + //
                        "\n" + //
                        "⚠️ Lưu ý: Đây không phải một “cuốn sách cố định”, mà thường là tài liệu tổng hợp dùng để ôn thi Tin học cơ bản (trường học, chứng chỉ, hoặc kỹ năng văn phòng). Vì vậy cấu trúc dưới đây là dạng chuẩn phổ biến nhất.\n" + //
                        "\n" + //
                        "Tóm tắt toàn bộ nội dung\n" + //
                        "\n" + //
                        "Tài liệu Tin học cơ bản giúp người học:\n" + //
                        "\n" + //
                        "Hiểu cấu trúc máy tính và hệ điều hành\n" + //
                        "Sử dụng thành thạo máy tính cơ bản\n" + //
                        "Làm việc với phần mềm văn phòng (Word, Excel, PowerPoint)\n" + //
                        "Sử dụng Internet và email\n" + //
                        "Nắm các kỹ năng xử lý dữ liệu đơn giản\n" + //
                        "\n" + //
                        "Mục tiêu:\n" + //
                        "\n" + //
                        "Trang bị kỹ năng sử dụng máy tính và phần mềm cơ bản để học tập và làm việc hiệu quả.\n" + //
                        "\n" + //
                        "Cấu trúc và các chương\n" + //
                        "CHƯƠNG 1. TỔNG QUAN VỀ MÁY TÍNH\n" + //
                        "Nội dung\n" + //
                        "Khái niệm máy tính\n" + //
                        "Phần cứng và phần mềm\n" + //
                        "CPU, RAM, ổ cứng\n" + //
                        "Thiết bị ngoại vi\n" + //
                        "Ý nghĩa\n" + //
                        "\n" + //
                        "Hiểu cấu tạo và nguyên lý hoạt động máy tính.\n" + //
                        "\n" + //
                        "CHƯƠNG 2. HỆ ĐIỀU HÀNH\n" + //
                        "Nội dung\n" + //
                        "Windows/Linux cơ bản\n" + //
                        "Quản lý file và thư mục\n" + //
                        "Cài đặt phần mềm\n" + //
                        "Desktop, taskbar\n" + //
                        "Ý nghĩa\n" + //
                        "\n" + //
                        "Biết cách vận hành máy tính.\n" + //
                        "\n" + //
                        "CHƯƠNG 3. SOẠN THẢO VĂN BẢN (MICROSOFT WORD)\n" + //
                        "Nội dung\n" + //
                        "Gõ và định dạng văn bản\n" + //
                        "Căn lề, font chữ, đoạn văn\n" + //
                        "Chèn bảng, hình ảnh\n" + //
                        "In ấn tài liệu\n" + //
                        "Ý nghĩa\n" + //
                        "\n" + //
                        "Tạo văn bản chuyên nghiệp.\n" + //
                        "\n" + //
                        "CHƯƠNG 4. BẢNG TÍNH (MICROSOFT EXCEL)\n" + //
                        "Nội dung\n" + //
                        "Nhập dữ liệu\n" + //
                        "Công thức cơ bản (SUM, AVERAGE…)\n" + //
                        "Biểu đồ\n" + //
                        "Sắp xếp và lọc dữ liệu\n" + //
                        "Ý nghĩa\n" + //
                        "\n" + //
                        "Xử lý số liệu hiệu quả.\n" + //
                        "\n" + //
                        "CHƯƠNG 5. TRÌNH CHIẾU (POWERPOINT)\n" + //
                        "Nội dung\n" + //
                        "Tạo slide\n" + //
                        "Chèn hình ảnh, video\n" + //
                        "Hiệu ứng chuyển động\n" + //
                        "Trình chiếu\n" + //
                        "Ý nghĩa\n" + //
                        "\n" + //
                        "Trình bày thông tin trực quan.\n" + //
                        "\n" + //
                        "CHƯƠNG 6. INTERNET VÀ EMAIL\n" + //
                        "Nội dung\n" + //
                        "Trình duyệt web\n" + //
                        "Tìm kiếm thông tin\n" + //
                        "Gửi và nhận email\n" + //
                        "An toàn mạng\n" + //
                        "Ý nghĩa\n" + //
                        "\n" + //
                        "Kết nối và trao đổi thông tin.\n" + //
                        "\n" + //
                        "CHƯƠNG 7. AN TOÀN THÔNG TIN\n" + //
                        "Nội dung\n" + //
                        "Virus máy tính\n" + //
                        "Phần mềm độc hại\n" + //
                        "Bảo mật tài khoản\n" + //
                        "Sao lưu dữ liệu\n" + //
                        "Ý nghĩa\n" + //
                        "\n" + //
                        "Bảo vệ dữ liệu cá nhân.\n" + //
                        "\n" + //
                        "CHƯƠNG 8. KỸ NĂNG ỨNG DỤNG TỔNG HỢP\n" + //
                        "Nội dung\n" + //
                        "Kết hợp Word – Excel – PowerPoint\n" + //
                        "Làm báo cáo hoàn chỉnh\n" + //
                        "Quản lý dữ liệu\n" + //
                        "Ý nghĩa\n" + //
                        "\n" + //
                        "Ứng dụng vào công việc thực tế.");
        // #endregion
        b37.setCategory(c5);
        b37.setAuthors(new ArrayList<>(Arrays.asList(a28)));
        b37.setCoverImage("/images/2486-tai-lieu-on-tap-tin-hoc-co-ban-1.webp");
        bookRepository.save(b37);

        Book b38 = new Book();
        b38.setBookName("CHATGPT - ỨNG DỤNG TRÍ TUỆ NHÂN TẠO TRONG CÔNG VIỆC");
        b38.setPublisher("Công Thương");
        b38.setYearPublish(2024);
        b38.setQuantity(5);
        b38.setBorrowCount(1);
        // #region Book Detail   
        b38.setBookDetail("ChatGPT – Ứng Dụng Trí Tuệ Nhân Tạo Trong Công Việc\n" + //
                        "Tóm tắt và các chương\n" + //
                        "\n" + //
                        "⚠️ Lưu ý: Đây là dạng sách kỹ năng ứng dụng AI (không phải giáo trình cố định), nên cấu trúc dưới đây là bản tổng hợp phổ biến theo nội dung các tài liệu về ChatGPT trong môi trường làm việc.\n" + //
                        "\n" + //
                        "Tóm tắt toàn bộ nội dung\n" + //
                        "\n" + //
                        "Cuốn sách hướng dẫn cách:\n" + //
                        "\n" + //
                        "Sử dụng ChatGPT như một trợ lý AI để tăng năng suất, giảm thời gian làm việc và tự động hóa các nhiệm vụ trong công việc hàng ngày.\n" + //
                        "\n" + //
                        "Nội dung tập trung vào:\n" + //
                        "\n" + //
                        "Cách hiểu và sử dụng ChatGPT đúng cách\n" + //
                        "Kỹ thuật viết prompt hiệu quả\n" + //
                        "Ứng dụng trong văn phòng, kinh doanh, học tập, lập trình\n" + //
                        "Tạo nội dung nhanh (email, báo cáo, kế hoạch)\n" + //
                        "Tự động hóa công việc với AI\n" + //
                        "Rủi ro và giới hạn khi dùng AI\n" + //
                        "Cấu trúc và các chương\n" + //
                        "CHƯƠNG 1. GIỚI THIỆU VỀ CHATGPT VÀ AI NGÔN NGỮ\n" + //
                        "Nội dung\n" + //
                        "ChatGPT là gì\n" + //
                        "AI ngôn ngữ hoạt động như thế nào\n" + //
                        "Sự khác biệt giữa ChatGPT và công cụ tìm kiếm\n" + //
                        "Ý nghĩa\n" + //
                        "\n" + //
                        "Hiểu nền tảng công nghệ trước khi sử dụng.\n" + //
                        "\n" + //
                        "CHƯƠNG 2. NGUYÊN LÝ HOẠT ĐỘNG CỦA CHATGPT\n" + //
                        "Nội dung\n" + //
                        "Mô hình ngôn ngữ lớn (LLM)\n" + //
                        "Dự đoán từ tiếp theo\n" + //
                        "Giới hạn và lỗi AI\n" + //
                        "Ý nghĩa\n" + //
                        "\n" + //
                        "Giúp người dùng hiểu đúng bản chất AI.\n" + //
                        "\n" + //
                        "CHƯƠNG 3. KỸ NĂNG VIẾT PROMPT HIỆU QUẢ\n" + //
                        "Nội dung\n" + //
                        "Prompt là gì\n" + //
                        "Công thức viết prompt (vai trò – nhiệm vụ – ngữ cảnh – yêu cầu)\n" + //
                        "Ví dụ thực tế\n" + //
                        "Ý nghĩa\n" + //
                        "\n" + //
                        "Đây là kỹ năng quan trọng nhất khi dùng ChatGPT.\n" + //
                        "\n" + //
                        "CHƯƠNG 4. CHATGPT TRONG CÔNG VIỆC VĂN PHÒNG\n" + //
                        "Nội dung\n" + //
                        "Soạn email\n" + //
                        "Viết báo cáo\n" + //
                        "Tóm tắt tài liệu\n" + //
                        "Lập kế hoạch\n" + //
                        "Ý nghĩa\n" + //
                        "\n" + //
                        "Tăng năng suất công việc hành chính.\n" + //
                        "\n" + //
                        "CHƯƠNG 5. CHATGPT TRONG KINH DOANH VÀ MARKETING\n" + //
                        "Nội dung\n" + //
                        "Viết nội dung quảng cáo\n" + //
                        "Lên ý tưởng marketing\n" + //
                        "Phân tích khách hàng\n" + //
                        "Viết kịch bản bán hàng\n" + //
                        "Ý nghĩa\n" + //
                        "\n" + //
                        "Hỗ trợ tăng doanh thu và hiệu quả kinh doanh.\n" + //
                        "\n" + //
                        "CHƯƠNG 6. CHATGPT TRONG HỌC TẬP\n" + //
                        "Nội dung\n" + //
                        "Giải thích kiến thức\n" + //
                        "Tóm tắt sách\n" + //
                        "Học ngoại ngữ\n" + //
                        "Hỗ trợ viết bài luận\n" + //
                        "Ý nghĩa\n" + //
                        "\n" + //
                        "Cá nhân hóa quá trình học.\n" + //
                        "\n" + //
                        "CHƯƠNG 7. CHATGPT TRONG LẬP TRÌNH\n" + //
                        "Nội dung\n" + //
                        "Viết code\n" + //
                        "Sửa lỗi (debug)\n" + //
                        "Giải thích thuật toán\n" + //
                        "Tạo project mẫu\n" + //
                        "Ý nghĩa\n" + //
                        "\n" + //
                        "Hỗ trợ lập trình nhanh hơn.\n" + //
                        "\n" + //
                        "CHƯƠNG 8. TỰ ĐỘNG HÓA CÔNG VIỆC\n" + //
                        "Nội dung\n" + //
                        "Kết hợp AI với công cụ (API, Zapier, Notion…)\n" + //
                        "Workflow tự động\n" + //
                        "AI agents\n" + //
                        "Ý nghĩa\n" + //
                        "\n" + //
                        "Giảm công việc thủ công.\n" + //
                        "\n" + //
                        "CHƯƠNG 9. GIỚI HẠN VÀ RỦI RO\n" + //
                        "Nội dung\n" + //
                        "Sai thông tin\n" + //
                        "Bảo mật dữ liệu\n" + //
                        "Lạm dụng AI\n" + //
                        "Phụ thuộc vào công nghệ\n" + //
                        "Ý nghĩa\n" + //
                        "\n" + //
                        "Dùng AI có trách nhiệm.\n" + //
                        "\n" + //
                        "CHƯƠNG 10. TƯƠNG LAI CÔNG VIỆC VỚI CHATGPT\n" + //
                        "Nội dung\n" + //
                        "AI thay đổi thị trường lao động\n" + //
                        "Kỹ năng cần thiết tương lai\n" + //
                        "Mô hình con người + AI\n" + //
                        "Ý nghĩa\n" + //
                        "\n" + //
                        "Định hướng nghề nghiệp thời đại AI.");
        // #endregion
        b38.setCategory(c5);
        b38.setAuthors(new ArrayList<>(Arrays.asList(a27)));
        b38.setCoverImage("/images/6050-chatgpt-ung-dung-tri-tue-nhan-tao-trong-cong-viec-1.webp");
        bookRepository.save(b38);
    }
}