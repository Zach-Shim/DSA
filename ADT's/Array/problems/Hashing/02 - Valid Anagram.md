## 1. Listen

**Problem Statement:**
Given two strings `s` and `t`, return `true` _if_ `t` _is an anagram of_ `s`_, and_ `false` _otherwise_.

An **Anagram** is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

**Input:**
string `s` 
string `t`

**Goal:**
determine if `s` is an anagram of `t`

**Return:**
if `s` is an anagram of `t` return true
if `s` is not an anagram of `t` return false
## 2. Example

**Example 1: True (s and t are same length and same letters)**
**Input:** s = "anagram", t = "nagaram"
**Output:** true

**Example 2: False (s and t are same length and different letters)**
**Input:** s = "rat", t = "car"
**Output:** false

**Example 3: False (s and t are different length)**
**Input:** s = "rat", t = "nagaram"
**Output:** false
## 3. List Constraints

**Observations & Assumptions:**
- s and t are only ASCII lowercase English letters

**Constraints:**
- 1 <= s.length, t.length <= 5 * 10^4
- s and t consist of lowercase English letters

**Edge Cases:**
- 
## 4. Brute Force

**Solution 1: Count Letter Frequency**
Keep a frequency array of size 26 (number of lowercase letters in English) to store frequency of letters.
Increment all occurrences of each character in `s` in the frequency array.
Decrement all occurrences of each character in `t` in the frequency array.
If any time we decrement from the frequency array and its value goes below 0, then `s` and `t` have different letters or different letter frequency. Therefore, we return false.
If we never go below 0 when decrementing, return true.

Time: O(2N)
Space: O(1)
## 5. Optimizations

**Solution 2: HashMap**
To account for unicode characters, we can instead use a HashMap instead of a static frequency array. This also allows us to scale the algorithm to allow any type of character.
The logic is the same as Solution 1.
## 6. Walkthrough


## 7. Implement

```Java

```
## 8. Test
