(ns day18.core-test
  (:require [clojure.test :refer :all]
            [day18.core :refer :all]))

(deftest test-explode
  (testing "exploding pairs"
    (is (= (explode (to-tree [[[[[9, 8], 1], 2], 3], 4])) (to-tree [[[[0, 9], 2], 3], 4])))
    (is (= (explode (to-tree [7, [6, [5, [4, [3, 2]]]]])) (to-tree [7, [6, [5, [7, 0]]]])))
    (is (= (explode (to-tree [[6, [5, [4, [3, 2]]]], 1])) (to-tree [[6, [5, [7, 0]]], 3])))
    (is (= (explode (to-tree [[3, [2, [1, [7, 3]]]], [6, [5, [4, [3, 2]]]]])) (to-tree [[3, [2, [8, 0]]], [9, [5, [4, [3, 2]]]]])))
    (is (= (explode (to-tree [[3, [2, [8, 0]]], [9, [5, [4, [3, 2]]]]])) (to-tree [[3, [2, [8, 0]]], [9, [5, [7, 0]]]])))
    (is (= (explode (to-tree [[[[[4, 3], 4], 4], [7, [[8, 4], 9]]], [1, 1]])) (to-tree [[[[0, 7], 4], [7, [[8, 4], 9]]], [1, 1]])))
    (is (= (explode (to-tree [[[[0, 7], 4], [7, [[8, 4], 9]]], [1, 1]])) (to-tree [[[[0, 7], 4], [15, [0, 13]]], [1, 1]])))
    (is (= (explode (to-tree [[[[0, 7], 4], [[7, 8], [0, [6, 7]]]], [1, 1]])) (to-tree [[[[0, 7], 4], [[7, 8], [6, 0]]], [8, 1]])))))

;; (deftest test-pos-of-exploding-pair
;;   (testing "position of the exploding pair"
;;     (is (= 5 (pos-exploding-pair (to-tree [[[[0,7],4],[7,[[8,4],9]]],[1,1]]))))
;;     (is (= 1 (pos-exploding-pair (to-tree [[[[[4,3],4],4],[7,[[8,4],9]]],[1,1]]))))
;;     (is (= 7 (pos-exploding-pair (to-tree [[[[0,7],4],[[7,8],[0,[6,7]]]],[1,1]]))))))

(deftest test-reduce
  (testing "reducing snailfish number"
    (is (= (sf-reduce (to-tree [[[[[4,3],4],4],[7,[[8,4],9]]],[1,1]])) (to-tree [[[[0,7],4],[[7,8],[6,0]]],[8,1]])))
    (is (= (sf-reduce (to-tree [[[[1,1],[2,2]],[3,3]],[4,4]])) (to-tree [[[[1,1],[2,2]],[3,3]],[4,4]])))))

(deftest test-add
  (testing "adding snailfish numbers"
    (is (= (sf-add (to-tree [[[[4,3],4],4],[7,[[8,4],9]]]) (to-tree [1,1])) (to-tree [[[[0,7],4],[[7,8],[6,0]]],[8,1]])))
    (is (= (sf-add (to-tree [[[[1,1],[2,2]],[3,3]],[4,4]]) (to-tree [5,5])) (to-tree [[[[3,0],[5,3]],[4,4]],[5,5]])))
    (is (= (sf-add (to-tree [[[[3,0],[5,3]],[4,4]],[5,5]]) (to-tree [6,6])) (to-tree [[[[5,0],[7,4]],[5,5]],[6,6]])))
    (is (= (sf-add (to-tree [[[0,[4,5]],[0,0]],[[[4,5],[2,6]],[9,5]]]) (to-tree [7,[[[3,7],[4,3]],[[6,3],[8,8]]]])) (to-tree [[[[4,0],[5,4]],[[7,7],[6,0]]],[[8,[7,7]],[[7,9],[5,0]]]])))
    (is (= (sf-add (to-tree [[[[4,0],[5,4]],[[7,7],[6,0]]],[[8,[7,7]],[[7,9],[5,0]]]]) (to-tree [[2,[[0,8],[3,4]]],[[[6,7],1],[7,[1,6]]]])) (to-tree [[[[6,7],[6,7]],[[7,7],[0,7]]],[[[8,7],[7,7]],[[8,8],[8,0]]]])))
    (is (= (sf-add (to-tree [[[[6,7],[6,7]],[[7,7],[0,7]]],[[[8,7],[7,7]],[[8,8],[8,0]]]]) (to-tree [[[[2,4],7],[6,[0,5]]],[[[6,8],[2,8]],[[2,1],[4,5]]]])) (to-tree [[[[7,0],[7,7]],[[7,7],[7,8]]],[[[7,7],[8,8]],[[7,7],[8,7]]]])))))

(deftest test-final
  (testing "part 1 & 2"
    (let [input "[[[0,[5,8]],[[1,7],[9,6]]],[[4,[1,2]],[[1,4],2]]]
[[[5,[2,8]],4],[5,[[9,9],0]]]
[6,[[[6,2],[5,6]],[[7,6],[4,7]]]]
[[[6,[0,7]],[0,9]],[4,[9,[9,0]]]]
[[[7,[6,4]],[3,[1,3]]],[[[5,5],1],9]]
[[6,[[7,3],[3,2]]],[[[3,8],[5,7]],4]]
[[[[5,4],[7,7]],8],[[8,3],8]]
[[9,3],[[9,9],[6,[4,9]]]]
[[2,[[7,7],7]],[[5,8],[[9,3],[0,2]]]]
[[[[5,2],5],[8,[3,7]]],[[5,[7,5]],[4,4]]]"]
      (is (= 4140 (part1 input)))
      (is (= 3993 (part2 input))))))
