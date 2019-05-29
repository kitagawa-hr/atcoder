#[allow(unused_macros)]
macro_rules! input {
    (source = $s:expr, $($r:tt)*) => {
        let mut iter = $s.split_whitespace();
        let mut next = || { iter.next().unwrap() };
        input_inner!{next, $($r)*}
    };
    ($($r:tt)*) => {
        let stdin = std::io::stdin();
        let mut bytes = std::io::Read::bytes(std::io::BufReader::new(stdin.lock()));
        let mut next = move || -> String{
            bytes
                .by_ref()
                .map(|r|r.unwrap() as char)
                .skip_while(|c|c.is_whitespace())
                .take_while(|c|!c.is_whitespace())
                .collect()
        };
        input_inner!{next, $($r)*}
    };
}

#[allow(unused_macros)]
macro_rules! input_inner {
    ($next:expr) => {};
    ($next:expr, ) => {};

    ($next:expr, $var:ident : $t:tt $($r:tt)*) => {
        let $var = read_value!($next, $t);
        input_inner!{$next $($r)*}
    };
}

#[allow(unused_macros)]
macro_rules! read_value {
    ($next:expr, ( $($t:tt),* )) => {
        ( $(read_value!($next, $t)),* )
    };

    ($next:expr, [ $t:tt ; $len:expr ]) => {
        (0..$len).map(|_| read_value!($next, $t)).collect::<Vec<_>>()
    };

    ($next:expr, chars) => {
        read_value!($next, String).chars().collect::<Vec<char>>()
    };

    ($next:expr, bytes) => {
        read_value!($next, String).into_bytes()
    };

    ($next:expr, usize1) => {
        read_value!($next, usize) - 1
    };

    ($next:expr, $t:ty) => {
        $next().parse::<$t>().expect("Parse error")
    };
}

fn dfs(x: usize, y: usize, c: Vec<Vec<char>>, cache: Vec<Vec<i32>>) -> bool {
    let w = c.len();
    let h = c[0].len();
    if x < 0 || y < 0 || x >= w || y >= h || c[y][x] == '#' || cache[y][x] == 1 {
        return false;
    }
    cache[y][x] = 1;
    if c[y][x] == 'g' {
        return true;
    } else {
        return dfs(x + 1, y) || dfs(x - 1, y) || dfs(x, y + 1) || dfs(x, y - 1);
    }
}

fn main() {
    input! {
        h: usize,
        w: usize,
        c: [chars; h],
    }
    let cache: Vec<Vec<i32>> = vec![vec![0; w]; h];
    let mut s1 = 0;
    let mut s2 = 0;
    for i in 0..w {
        for j in 0..h {
            if c[j][i] == 's' {
                s1 = i;
                s2 = j;
            }
        }
    }
    if dfs(s1, s2, c, cache) {
        println!("Yes");
    } else {
        println!("No");
    }
}
