import strutils, sequtils

let
  tmp = (split readLine stdin).map(parseInt)
  (H, W) = (tmp[0], tmp[1])
var
  maze: seq[string] = @[]
  visited = newSeqWith(H, newSeq[bool](W))
  s1, s2: int


proc dfs(x:int, y: int) : bool =
  if x < 0 or y < 0 or x >= W or y>=H or maze[y][x] == '#' or visited[y][x]:
    return false
  visited[y][x] = true
  if maze[y][x] == 'g':
    return true
  return dfs(x + 1, y) or dfs(x - 1, y) or dfs(x, y + 1) or dfs(x, y - 1)

for y in 0 ..< H:
  maze.add(readLine stdin)
  for x in 0 ..< W:
    if maze[y][x] == 's':
      (s1, s2) = (x, y)

if dfs(s1, s2):
  echo "Yes"
else:
  echo "No"
