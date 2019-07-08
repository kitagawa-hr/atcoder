
#### Contest started

AtCoder Beginner Contest 132 has begun.

#### Contest is over

AtCoder Beginner Contest 132 has ended.

				
					- <a class="contest-title" href='/contests/abc132'>AtCoder Beginner Contest 132</a>
				
				
					
					<li class="dropdown">
						<a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
							<img src='//img.atcoder.jp/assets/flag-lang/en.png'> English 
						</a>
						<ul class="dropdown-menu">
							- <a href='/contests/abc132/tasks/abc132_e?lang=ja'><img src='//img.atcoder.jp/assets/flag-lang/ja.png'> 日本語</a>
							- <a href='/contests/abc132/tasks/abc132_e?lang=en'><img src='//img.atcoder.jp/assets/flag-lang/en.png'> English</a>
						
		- <a href='/contests/abc132'> Top</a>
		
			- <a href='/contests/abc132/tasks'> Tasks</a>
		

		
			- <a href='/contests/abc132/clarifications'> Clarifications </a>
		

		

		
			<li>
				[ Submissions](#)
				<ul class="dropdown-menu">
					- <a href='/contests/abc132/submissions'> All Submissions</a>
					
				
---


Time Limit: 2 sec / Memory Limit: 1024 MB

配点 : <var>500</var> 点

### 問題文

ケンくんはけんけんぱが大好きです。今日は有向グラフ <var>G</var> の上でけんけんぱをすることにしました。
<var>G</var> は <var>1</var> から <var>N</var> で番号付けされた <var>N</var> 頂点および <var>M</var> 辺からなり、
<var>i</var> 番目の辺は頂点 <var>u_i</var> から頂点 <var>v_i</var> に接続しています。

ケンくんははじめ頂点 <var>S</var> にいて、頂点 <var>T</var> までけんけんぱで移動したいです。
<var>1</var> 回のけんけんぱでは、「自分の今いる頂点から出ている辺を <var>1</var> つ選んで、その辺が接続する頂点に移動する」という操作をちょうど <var>3</var> 回連続で行います。

ケンくんが頂点 <var>T</var> に移動することができるか、また移動できるなら最小何回のけんけんぱで頂点 <var>T</var> まで移動することができるかを答えてください。
けんけんぱの操作の途中で頂点 <var>T</var> に訪れても、「頂点 <var>T</var> に移動できた」とは見なさないことに注意してください。

### 制約

- <var>2 \leq N \leq 10^5</var>
- <var>0 \leq M \leq \min(10^5, N (N-1))</var>
- <var>1 \leq u_i, v_i \leq N(1 \leq i \leq M)</var>
- <var>u_i \neq v_i (1 \leq i \leq M)</var>
- <var>i \neq j</var> ならば <var>(u_i, v_i) \neq (u_j, v_j)</var>
- <var>1 \leq S, T \leq N</var>
- <var>S \neq T</var>

### 入力

入力は以下の形式で標準入力から与えられる。

### 出力

何回けんけんぱを繰り返しても頂点 <var>S</var> から頂点 <var>T</var> へ移動できない場合には、<var>-1</var> を出力せよ。
移動できる場合には、移動するのに必要なけんけんぱの最小回数を出力せよ。

### 入力例 1

### 出力例 1

<var>1</var> 回目のけんけんぱでは <var>1 \rightarrow 2 \rightarrow 3 \rightarrow 4</var>、<var>2</var> 回目のけんけんぱでは <var>4 \rightarrow 1 \rightarrow 2 \rightarrow 3</var> と移動することで頂点 <var>3</var> に辿り着くことができ、これが最小回数です。

### 入力例 2

### 出力例 2

何回けんけんぱを繰り返しても頂点 <var>1</var> に辿り着くため、頂点 <var>2</var> に移動することは不可能です。
けんけんぱの途中で頂点 <var>2</var> を通過することはできますが、これは移動できたとは見なしません。

### 入力例 3

### 出力例 3

頂点 <var>S</var> と頂点 <var>T</var> は非連結である場合があります。

### 入力例 4

### 出力例 4

Score : <var>500</var> points

### Problem Statement

Ken loves **ken-ken-pa** (Japanese version of hopscotch). Today, he will play it on a directed graph <var>G</var>.
<var>G</var> consists of <var>N</var> vertices numbered <var>1</var> to <var>N</var>, and <var>M</var> edges. The <var>i</var>-th edge points from Vertex <var>u_i</var> to Vertex <var>v_i</var>.

First, Ken stands on Vertex <var>S</var>. He wants to reach Vertex <var>T</var> by repeating ken-ken-pa. In one ken-ken-pa, he does the following exactly three times: follow an edge pointing from the vertex on which he is standing.

Determine if he can reach Vertex <var>T</var> by repeating ken-ken-pa. If the answer is yes, find the minimum number of ken-ken-pa needed to reach Vertex <var>T</var>. Note that visiting Vertex <var>T</var> in the middle of a ken-ken-pa does not count as reaching Vertex <var>T</var> by repeating ken-ken-pa.

### Constraints

- <var>2 \leq N \leq 10^5</var>
- <var>0 \leq M \leq \min(10^5, N (N-1))</var>
- <var>1 \leq u_i, v_i \leq N(1 \leq i \leq M)</var>
- <var>u_i \neq v_i (1 \leq i \leq M)</var>
- If <var>i \neq j</var>, <var>(u_i, v_i) \neq (u_j, v_j)</var>.
- <var>1 \leq S, T \leq N</var>
- <var>S \neq T</var>

### Input

Input is given from Standard Input in the following format:

### Output

If Ken cannot reach Vertex <var>T</var> from Vertex <var>S</var> by repeating ken-ken-pa, print <var>-1</var>.
If he can, print the minimum number of ken-ken-pa needed to reach vertex <var>T</var>.

### Sample Input 1

### Sample Output 1

Ken can reach Vertex <var>3</var> from Vertex <var>1</var> in two ken-ken-pa, as follows: <var>1 \rightarrow 2 \rightarrow 3 \rightarrow 4</var> in the first ken-ken-pa, then <var>4 \rightarrow 1 \rightarrow 2 \rightarrow 3</var> in the second ken-ken-pa. This is the minimum number of ken-ken-pa needed.

### Sample Input 2

### Sample Output 2

Any number of ken-ken-pa will bring Ken back to Vertex <var>1</var>, so he cannot reach Vertex <var>2</var>, though he can pass through it in the middle of a ken-ken-pa.

### Sample Input 3

### Sample Output 3

Vertex <var>S</var> and Vertex <var>T</var> may be disconnected.

### Sample Input 4

### Sample Output 4

				- <a href='/contests/abc132/rules'>Rule</a>
				- <a href='/contests/abc132/glossary'>Glossary</a>
				
			
			- <a href='/tos'>Terms of service</a>
			- <a href='/privacy'>Privacy Policy</a>
			- <a href='/personal'>Information Protection Policy</a>
			- <a href='/company'>Company</a>
			- <a href='/faq'>FAQ</a>
			- <a href='/contact'>Contact</a>
			
		

