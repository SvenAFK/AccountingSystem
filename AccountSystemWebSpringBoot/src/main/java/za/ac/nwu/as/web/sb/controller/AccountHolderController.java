package za.ac.nwu.as.web.sb.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.nwu.as.domain.dto.AccountHolderDto;
import za.ac.nwu.as.domain.service.GeneralResponse;
import za.ac.nwu.as.logic.flow.CreateAccountHolderFlow;
import za.ac.nwu.as.logic.flow.FetchAccountHolderFlow;
import za.ac.nwu.as.logic.flow.ModifyAccountHolderFlow;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("account-holder")
public class AccountHolderController {

    private final FetchAccountHolderFlow fetchAccountHolderFlow;
    private final CreateAccountHolderFlow createAccountHolderFlow;
    private final ModifyAccountHolderFlow modifyAccountHolderFlow;

    public AccountHolderController(FetchAccountHolderFlow fetchAccountHolderFlow, CreateAccountHolderFlow createAccountHolderFlow,ModifyAccountHolderFlow modifyAccountHolderFlow) {
        this.fetchAccountHolderFlow = fetchAccountHolderFlow;
        this.createAccountHolderFlow = createAccountHolderFlow;
        this.modifyAccountHolderFlow = modifyAccountHolderFlow;
    }

    @PostMapping("")
    @ApiOperation(value = "Create a new AccountHolder.", notes = "Creates a new AccountHolder in the DB.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "The AccountHolder (member) was created successfully", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<AccountHolderDto>> create(
            @ApiParam(value = "Request body to create a new AccountHolder or Member.", required = true)
            @RequestBody AccountHolderDto AccountHolder) {
        AccountHolderDto AccountHolderResponse = createAccountHolderFlow.create(AccountHolder);
        GeneralResponse<AccountHolderDto> response = new GeneralResponse<>(true, AccountHolderResponse);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    @ApiOperation(value = "Gets all the configured Account holders", notes = "Returns a list of account holders")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Account holders returned", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<List<AccountHolderDto>>> getAll() {
        List<AccountHolderDto> AccountHolderResponse = fetchAccountHolderFlow.getAllAccountHolders();
        GeneralResponse<List<AccountHolderDto>> response = new GeneralResponse<>(true, AccountHolderResponse);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{memberId}")
    @ApiOperation(value = "Fetch the specified AccountHolder.", notes = "Fetch the AccountHolder corresponding to the given memberId")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The AccountHolder was found successfully", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)
    })
    public ResponseEntity<GeneralResponse<AccountHolderDto>> getAccountHolder(
            @ApiParam(value = "The memberId that uniquely identifies the AccountHolder.",
                    example = "5061",
                    name = "memberId",
                    required = true)
            @PathVariable("memberId") final int memberId) {
        AccountHolderDto AccountHolderResponse = fetchAccountHolderFlow.getAccountHolderById(memberId);
        GeneralResponse<AccountHolderDto> response = new GeneralResponse<>(true, AccountHolderResponse);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("{memberId}")
    @ApiOperation(value = "Updates the specified AccountHolder.", notes = "Updates the AccountHolder corresponding to the given memberId")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "AccountHolder Updated", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Recourse not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)
    })
    public ResponseEntity<GeneralResponse<AccountHolderDto>> updateAccountHolder(
            @ApiParam(value = "The memberId that uniquely identifies the AccountHolder.",
                    name = "memberId",
                    required = true)
            @PathVariable("memberId") final int memberId,
            @ApiParam(value = "The memberName that the specified AccountHolder should be updated with.",
                    name = "memberName",
                    required = true)
            @RequestParam("memberName") final String memberName,
            @ApiParam(value = "The AccountHolder balance that the specified AccountHolder should be updated with.",
                    name = "newAccountHolderBalance",
                    required = true)
            @RequestParam("balance") final int balance,
            @ApiParam(value = "The AccountHolder currency that the specified AccountHolder should be updated with.",
                    name = "newAccountHolderCurrency",
                    required = true)
            @RequestParam("currency") final String currency,
            @ApiParam(value = "The new starting date on the service that adds Miles for a member in ISO date format (yyyy-MM-dd)\r\n\f",
                    required = true)
            @RequestParam(value = "startDate", required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                    LocalDate startDate

    ) {
        AccountHolderDto AccountHolderResponse = modifyAccountHolderFlow.updateAccountHolder(memberId,memberName, balance, currency, startDate);
        GeneralResponse<AccountHolderDto> response = new GeneralResponse<>(true, AccountHolderResponse);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/{memberId}/subtractMiles")
    @ApiOperation(value = "Subtract the specified AccountHolder (member) MILES.", notes = "Subtract the AccountHolder corresponding to the given memberId")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "AccountHolder MILES subtracted", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)
    })
    public ResponseEntity<GeneralResponse<AccountHolderDto>> subtractMiles(
            @ApiParam(value = "The memberId that uniquely identifies the AccountType.",
                    example = "5061",
                    name = "memberId",
                    required = true)
            @RequestParam("memberId") final int memberId,
            @ApiParam(value = "The AccountHolder balance that the specified AccountHolder should be updated (subtracted) with.",
                    example = "50",
                    name = "balance",
                    required = true)
            @RequestParam("balance") final int newBalance
    ){
        AccountHolderDto AccountHolderResponse = modifyAccountHolderFlow.subtractMiles(memberId,newBalance);
        GeneralResponse<AccountHolderDto> response = new GeneralResponse<>(true, AccountHolderResponse);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @PutMapping("/addMiles")
    @ApiOperation(value = "Adds the specified AccountHolder (member) MILES.", notes = "Adds the AccountHolder corresponding to the given memberId")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "AccountHolder MILES added", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)
    })
    public ResponseEntity<GeneralResponse<AccountHolderDto>> addMiles(
            @ApiParam(value = "The memberId that uniquely identifies the AccountType.",
                    example = "5061",
                    name = "memberId",
                    required = true)
            @RequestParam("memberId") final int memberId,
            @ApiParam(value = "The AccountHolder balance that the specified AccountHolder should be updated (add) with.",
                    example = "100",
                    name = "balance",
                    required = true)
            @RequestParam("balance") final int balance)
    {
        AccountHolderDto AccountHolderResponse = modifyAccountHolderFlow.addMiles(memberId, balance);
        GeneralResponse<AccountHolderDto> response = new GeneralResponse<>(true, AccountHolderResponse);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


}
