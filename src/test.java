import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class test {
	public static void main(String[] args) throws Exception {
		List<Task> list = new ArrayList<>();
		list.add(new Task(LocalDate.of(2021, 10, 21), "牛乳を買う", true));
		list.add(new Task(LocalDate.of(2021, 9, 15), "○○社面接", false));
		list.add(new Task(LocalDate.of(2021, 12, 4), "手帳を買う", true));
		list.add(new Task(LocalDate.of(2021, 8, 10), "散髪に行く", false));
		list.add(new Task(LocalDate.of(2021, 11, 9), "スクールの課題を解く", false));

		// 以下記述
		List<Task> mikanlist = new ArrayList<>();
		//リストをすべて取り出す
		for (Task mikanryou : list) {
			// if文で未完了か識別する
			if (mikanryou.isDone() == false) {
				// 未完了だったら未完リストに追加
				mikanlist.add(mikanryou);
			}
		}
		System.out.println("未完了のタスクの個数は" + mikanlist.size());
		System.out.println("【未完了のタスクを昇順に並び替えて一覧表示】");
		
		list.stream()
		.filter(l -> l.isDone() == false)
		.sorted(Comparator.comparing(l2 -> l2.getDate()))
		.forEach(System.out::println);
		

	}
}