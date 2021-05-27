import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

//「戦争」というトランプゲームをもじったオリジナルの一対一のカードゲーム。
//【ルール】Jokerと白紙のトランプを入れた計56枚のトランプをお互いランダムに出す。
//相手より出た数字が大きければプラス一点。10点先取で勝利。

public class report {
	public static void main(String[] args)throws IOException{

	int m=0; //自分の初期ポイント
	int c=0; //相手の初期ポイント
//配列
	String mark[]={"♥","♦","♠","♣"};
	Object[] kazu={1,2,3,4,5,6,7,8,9,10,11,12,13,"Joker","白紙"};

	System.out.println("♥♦♠♣カードゲームをはじめましょう ♥♦♠♣");

	//乱数生成
	Random random = new Random();
    //繰り返し文
	while(m<10&&c<10){
		System.out.println("---カードをひきますか?(y/n)---");
	//キーボード入力機能（yかnを入力）
		BufferedReader user =new BufferedReader(new InputStreamReader(System.in));
		String str = user.readLine();

		if(str.equals("n"))
		{
			System.out.println("\n"+"---ゲームが中断されたよ---");
    		break;
		}

		//自分の手を表示
		int mmark = random.nextInt(4);
		int mkazu = random.nextInt(15);
		//条件判定文
		if (mkazu==13)
		{
			System.out.println("あなたのカードは"+kazu[mkazu]);
		}
		else if (mkazu==14)
		{
			System.out.println("あなたのカードは"+kazu[mkazu]);
		}
		else
		{
			System.out.println("あなたのカードは"+mark[mmark]+kazu[mkazu]);
		}

        //相手の手を表示
		int cmark = random.nextInt(4);
		int ckazu = random.nextInt(15);

		if (ckazu==13)
		{
			System.out.println("相手のカードは"+kazu[ckazu]);
		}
		else if (ckazu==14)
		{
			System.out.println("相手のカードは"+kazu[ckazu]);
		}
		else
		{
	    System.out.println("相手のカードは"+mark[cmark]+kazu[ckazu]);
		}

	//ポイントシステム
    if(mkazu==ckazu) //白紙のカードと数字が同じカードが出た場合、ドローで点数変化なし。
    {
    	System.out.println("ドロー");
    	System.out.println("あなたのポイントは"+m+" 相手のポイントは"+c);
    }
    else if(mkazu==14||ckazu==14)
    {
    	System.out.println("ドロー");
    	System.out.println("あなたのポイントは"+m+" 相手のポイントは"+c);
    }
    else if(mmark==2 && mkazu==0) //特別カードの♠の１が出たら、プラス3点。
    {
    	m=m+3;
        System.out.println("☆★スペードのエースが出たよ！プラス3点★☆");
        System.out.println("あなたのポイントは"+m+ " 相手のポイントは"+c) ;
	}
    else if(cmark==2 && ckazu==0)
    {
    	c=c+3;
    	System.out.println("☆★相手がスペードのエースを出した！プラス3点★☆");
    	System.out.println("あなたのポイントは"+m+" 相手のポイントは"+c);
    }
    else if(mkazu==13) //Jokerが出た場合、相手のポイントをすべて奪う。
    {
    	m=m+c;
    	c=0;
    	System.out.println("Jokerがでたよ！相手のポイントを奪おう！");
    	System.out.println("あなたのポイントは"+m+" 相手のポイントは"+c) ;
    }
    else if(ckazu==13)
    {
    	c=c+m;
    	m=0;
    	System.out.println("Jokerがでたよ！ポイントが奪われる！");
    	System.out.println("あなたのポイントは"+m+" 相手のポイントは"+c);
    }
    else if(mkazu>ckazu && mkazu<13)
    {
        m+=1;
        System.out.println("あなたの勝ち！");
        System.out.println("あなたのポイントは"+m+" 相手のポイントは"+c) ;
    }
    else if(ckazu>mkazu && ckazu<13)
    {
    	c+=1;
    	System.out.println("相手の勝ち！");
        System.out.println("あなたのポイントは"+m+" 相手のポイントは"+c);
    }
    else{
    	System.out.println("finish");
    }
    }

	//ゲーム終了時
	if (m>=10)
	{
		System.out.println("---終了---");
		System.out.println("10ポイントに到達！あなたの勝利です！");
	}
	else if (c>=10)
	{
		System.out.println("---終了---");
		System.out.println("相手が合計10ポイントに到達！相手の勝利です");
	}
}
}
