
from typing import List
from typing import Set

class Solution:
    def numUniqueEmails(self, emails: List[str]) -> int:
        emailSet = set()
        for e in emails:
            name,domain = e.split('@')
            name = name.split('+')[0]
            sd = ''.join(name.split('.'))
            email = sd + '@' + domain
            print(email)
            emailSet.add(email)
        return len(emailSet)


if __name__ == "__main__":
    s = Solution()
    r = s.numUniqueEmails(['email.shanu@gmail.com', 'email.shanu+1@gmail.com','emailshanu@gmail.com'])
    print(r)