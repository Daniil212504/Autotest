# Autotest
Test case implementation 

Test case scenario:

1. Open url: wrike.com;
2.Click "Get started for free" button near "Login" button;
3. Fill in the email field with random generated value of email with mask “<random_text>+wpt@wriketask.qaa” (e.g. “abcdef+wpt@wriketask.qaa”);
4. Click on "Create my Wrike account" button + check with assertion that you are moved to the next page;
5. Fill in the Q&A section at the left part of page (like random generated answers) + that your answers are submitted;
6. Check that section "Follow us" at the site footer contains the "Twitter" button that leads to the correct url;
7. Create results report using allure plugin (by maven).  

Stack of technologies for implementation:

Platform: java;
Build and run: maven;
Test framework: junit4;
UI test: selenium 3; 
Reporting: allure plugin.
