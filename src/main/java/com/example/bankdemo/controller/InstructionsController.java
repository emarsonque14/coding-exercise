
package com.example.bankdemo.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InstructionsController {

    @GetMapping(value = "/instructions", produces = MediaType.TEXT_HTML_VALUE)
    public String instructions() {
        return """
        <!doctype html>
        <html lang="en">
        <head>
          <meta charset="utf-8"/>
          <meta name="viewport" content="width=device-width, initial-scale=1"/>
          <title>Coding Exercise</title>
          <style>
            body { font-family: system-ui, -apple-system, Segoe UI, Roboto, Arial, sans-serif; margin: 2rem; line-height: 1.5; }
            code, pre { background: #f6f8fa; padding: 2px 6px; border-radius: 4px; }
            h1, h2, h3 { margin-top: 1.2rem; }
            .box { border: 1px solid #e5e7eb; padding: 1rem; border-radius: 8px; }
            ul { margin: 0.4rem 0 1rem 1.1rem; }
          </style>
        </head>
        <body>
          <h1>Coding Exercise</h1>
          <p class="box">
            Implement a simple banking API with Accounts, Balances, and Transfers.
            The project is preloaded with H2, JPA, and sample data. Build <strong>REST endpoints</strong>
            and the necessary service/repository logic to meet the requirements below.
          </p>

          <h2>Entities & Tables</h2>
          <ul>
            <li><strong>Account</strong> (<code>accounts</code>): id, name, accountType (CA|SA), currency (e.g., PHP), createdAt, updatedAt</li>
            <li><strong>AccountBalance</strong> (<code>account_balances</code>): accountId (FK to Account, 1:1), balance, createdAt, updatedAt</li>
            <li><strong>Transfer</strong> (<code>transfers</code>): id, fromAccountId, toAccountId, amount, currency, transferDateTime, createdAt, updatedAt</li>
          </ul>

          <h2>What to Build</h2>
          <ol>
            <li><strong>Get Account Balance</strong>: GET <code>/accounts/{id}/balance</code> -> Get Balance of an account</li>
            <li><strong>Transfer Funds</strong>: POST <code>/transfers</code> -> Transfer money from account A to Account B</li>
          </ol>

          <h2>Business Rules</h2>
          <ul>
            <li>Only allow transfers where <strong>from/to accounts exist</strong> and are <strong>not the same</strong>.</li>
            <li><strong>Amount &gt; 0</strong> with <strong>max 2 decimal places</strong>.</li>
            <li><strong>No overdrafts</strong>: debited account balance must not go negative.</li>
            <li><strong>Same currency</strong> only (account currencies must match transfer currency).</li>
            <li>Persist a <strong>Transfer</strong> record for every successful transfer.</li>
          </ul>

          <h2>Non-Functional</h2>
          <ul>
            <li>Return appropriate HTTP status codes and JSON error bodies.</li>
            <li>Add basic unit tests (e.g., service-level transfer scenarios).</li>
          </ul>

          <h2>Notes</h2>
          <ul>
            <li>H2 console: <code>/h2-console</code> (JDBC URL: <code>jdbc:h2:mem:bankdb</code>, user: <code>sa</code>, blank password)</li>
            <li>Schema and seed data: <code>schema.sql</code>, <code>data.sql</code></li>
            <li>Feel free to refactor or add fields (e.g., versioning, audit) as needed.</li>
          </ul>

          <p>Good luck! 🚀</p>
        </body>
        </html>
        """;
    }
}
