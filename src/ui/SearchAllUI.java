package ui;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import dao.StudyGroupDAO;
import dao.StudyGroupDAOFactory;
import vo.StudyGroupVO;

public class SearchAllUI extends BaseUI {

	@Override
	public void execute() throws Exception {
	    List<StudyGroupVO> list = studyGroupService.searchStudyGroupAll();
	    Scanner sc = new Scanner(System.in);

	    // 정렬
	    System.out.print("정렬 기준을 선택하세요 (no/title/regDate): ");
	    String sortKey = sc.nextLine();

	    System.out.print("정렬 방향을 선택하세요 (asc/desc): ");
	    String sortOrder = sc.nextLine();

	    Comparator<StudyGroupVO> comparator = null;

	    switch(sortKey) {
	        case "no":
	            comparator = Comparator.comparing(StudyGroupVO::getNo);
	            break;
	        case "title":
	            comparator = Comparator.comparing(StudyGroupVO::getTitle);
	            break;
	        case "regDate":
	            comparator = Comparator.comparing(StudyGroupVO::getRegDate);
	            break;
	        default:
	            System.out.println("잘못된 정렬 기준입니다. 기본값(번호)으로 정렬합니다.");
	            comparator = Comparator.comparing(StudyGroupVO::getNo);
	    }
	    if("desc".equalsIgnoreCase(sortOrder)) {
	        comparator = comparator.reversed();
	    }
	    list.sort(comparator);

	    // 페이징
	    System.out.print("페이지 번호를 입력하세요(1부터 시작): ");
	    int page = Integer.parseInt(sc.nextLine());

	    System.out.print("페이지당 게시글 수를 입력하세요: ");
	    int pageSize = Integer.parseInt(sc.nextLine());

	    int total = list.size();
	    int totalPages = (int)Math.ceil((double)total / pageSize);

	    if(page < 1 || page > totalPages) {
	        System.out.println("잘못된 페이지 번호입니다.");
	        return;
	    }

	    int start = (page - 1) * pageSize;
	    int end = Math.min(start + pageSize, total);

	    System.out.println("==========================================");
	    System.out.println("\t전체게시글 조회 (페이지 " + page + "/" + totalPages + ")");
	    System.out.println("==========================================");
	    System.out.println("번호\t제목\t카테고리\t지역\t글쓴이\t등록일");
	    System.out.println("==========================================");

	    if(list.isEmpty()) {
	        System.out.println("\t게시글이 존재하지 않습니다");
	    } else {
	        for(int i = start; i < end; i++) {
	            StudyGroupVO studyGroup = list.get(i);
	            System.out.println(studyGroup.getNo() + "\t" + studyGroup.getTitle() + "\t" + studyGroup.getCategory() + "\t"
	                    + studyGroup.getRegion() + "\t" + studyGroup.getId() + "\t" + studyGroup.getRegDate());
	        }
	    }
	    System.out.println("==========================================");
	}
}